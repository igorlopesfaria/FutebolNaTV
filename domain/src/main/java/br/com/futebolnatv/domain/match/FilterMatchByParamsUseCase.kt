package br.com.futebolnatv.domain.match

import br.com.futebolnatv.commons.model.UseCase
import br.com.futebolnatv.domain.match.model.FilterMatchModel
import br.com.futebolnatv.model.MatchModel
import javax.inject.Inject

class FilterMatchByParamsUseCase @Inject constructor(): UseCase<FilterMatchModel, List<MatchModel>> {

    override suspend fun invoke(params: FilterMatchModel?): List<MatchModel> {
        var listMatchFiltered = params?.listMatch ?: emptyList();
        if (params?.dateFilter?.isNotEmpty() == true) {
            listMatchFiltered = listMatchFiltered.filter { match -> match.shortDate == params.dateFilter }
        }

        if (params?.teamNameFilter?.isNotEmpty()  == true)  {
            listMatchFiltered = listMatchFiltered.filter { match -> match.teamAway.name == params.teamNameFilter ||  match.teamHome.name == params.teamNameFilter }
        }

        if (params?.championshipFilter?.isNotEmpty() == true)  {
            listMatchFiltered = listMatchFiltered.filter { match -> match.championship == params.championshipFilter }
        }

        return listMatchFiltered
    }
}

