package br.com.futebolnatv.domain.match.model

import br.com.futebolnatv.model.MatchModel

data class FilterMatchModel (
    val teamNameFilter: String,
    val dateFilter: String,
    val championshipFilter: String,
    val listMatch: List<MatchModel>
)