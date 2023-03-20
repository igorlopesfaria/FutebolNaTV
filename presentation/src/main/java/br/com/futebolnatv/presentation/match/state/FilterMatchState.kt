package br.com.futebolnatv.presentation.match.state

sealed class FilterMatchState {
    object Loading : FilterMatchState()
    data class Success(val listChampionship: List<String>, val listDate: List<String>, val listTeam: List<String>) : FilterMatchState()
}
