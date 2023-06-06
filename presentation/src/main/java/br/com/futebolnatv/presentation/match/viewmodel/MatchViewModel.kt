package br.com.futebolnatv.presentation.match.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.futebolnatv.commons.extentions.getApiErrorType
import br.com.futebolnatv.commons.model.ApiErrorType
import br.com.futebolnatv.domain.match.FilterMatchByParamsUseCase
import br.com.futebolnatv.domain.match.FindAllMatchUseCase
import br.com.futebolnatv.domain.match.MakeChampionshipListUseCase
import br.com.futebolnatv.domain.match.MakeDateListUseCase
import br.com.futebolnatv.domain.match.MakeTeamListUseCase
import br.com.futebolnatv.domain.match.model.FilterMatchModel
import br.com.futebolnatv.model.MatchModel
import br.com.futebolnatv.presentation.match.state.FilterMatchState
import br.com.futebolnatv.presentation.match.state.MatchListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor(
    private val filterMatchUseCase: FilterMatchByParamsUseCase,
    private val findAllMatchUseCase: FindAllMatchUseCase,
    private val makeChampionshipListUseCase: MakeChampionshipListUseCase,
    private val makeDateListUseCase: MakeDateListUseCase,
    private val makeTeamListUseCase: MakeTeamListUseCase,
) : ViewModel() {

    private var _matchListState = MutableLiveData<MatchListState>()
    val matchListState: LiveData<MatchListState> get() = _matchListState

    private var _filterState = MutableLiveData<FilterMatchState>()
    val filterState: LiveData<FilterMatchState> get() = _filterState

    private var matchListOriginal = emptyList<MatchModel>()

    init {
        findAllMatches()
    }

    fun findAllMatches() {
        _matchListState.value = MatchListState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            findAllMatchUseCase.invoke().catch { throwable ->
                 _matchListState.postValue(
                     prepareError(throwable.getApiErrorType())
                 )
            }.collect { listMatch ->
                    if(listMatch.isEmpty())
                        _matchListState.postValue(MatchListState.Empty)
                    else
                        _matchListState.postValue(MatchListState.Success(listMatch))

            }
        }
    }

    private fun prepareError(errorType: ApiErrorType) = when(errorType) {
        is ApiErrorType.Network -> {
            MatchListState.InternetError
        }
        else -> {
            MatchListState.GenericError
        }
    }

    private fun createFilterList() {
        _filterState.value = FilterMatchState.Loading
        viewModelScope.launch(Dispatchers.Default) {
            _filterState.value = FilterMatchState.Success(
                listChampionship = makeChampionshipListUseCase.invoke(),
                listDate = makeDateListUseCase.invoke(),
                listTeam =  makeTeamListUseCase.invoke()
            )
        }
    }
    protected fun filterMatchByParam(teamNameFilter: String, dateFilter: String, championshipFilter: String) {
        _matchListState.value = MatchListState.Loading
        viewModelScope.launch(Dispatchers.Default) {
            _matchListState.value = MatchListState.Success(
                listMatch = filterMatchUseCase.invoke(
                    createFilterModel(teamNameFilter, dateFilter, championshipFilter)
                )
            )
        }
    }

    private fun createFilterModel(dateFilter: String, teamFilter: String, championshipFilter: String): FilterMatchModel = FilterMatchModel(
        teamNameFilter = teamFilter,
        dateFilter = dateFilter,
        championshipFilter = championshipFilter,
        listMatch = matchListOriginal
    )
}