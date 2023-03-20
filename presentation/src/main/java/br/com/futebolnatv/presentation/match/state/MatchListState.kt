package br.com.futebolnatv.presentation.match.state

import br.com.futebolnatv.commons.model.ApiErrorType
import br.com.futebolnatv.model.MatchModel

sealed class MatchListState {
    object Loading : MatchListState()
    object Empty : MatchListState()
    data class Success(val listMatch: List<MatchModel>) : MatchListState()
    data class Error(val title: String, val description: String, val tryAgain: Boolean, val icon: Int? = null) : MatchListState()
}
