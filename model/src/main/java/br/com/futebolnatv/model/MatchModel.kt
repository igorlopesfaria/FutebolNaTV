package br.com.futebolnatv.model

data class MatchModel(
    var championship: String,
    var stadium: String,
    var shortDate: String,
    var completeDate: String,
    var time: String,
    var channels: List<String>,
    var teamAway: TeamModel,
    var teamHome: TeamModel
)