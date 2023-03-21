package br.com.futebolnatv.data.match

import br.com.futebolnatv.data.match.datasource.model.MatchApiResponse
import br.com.futebolnatv.data.match.datasource.model.MatchItemApiResponse
import br.com.futebolnatv.data.match.datasource.model.TeamApiResponse
import br.com.futebolnatv.model.MatchModel
import br.com.futebolnatv.model.TeamModel

val teamHomeApiResponseMocked = TeamApiResponse (
    shortName = "BAH",
    name = "Bahia",
    shield = "http://urldeclubes/escudo_bahia.png"
)

val teamAwayApiResponseMocked = TeamApiResponse (
    shortName = "GRM",
    name = "Gremio",
    shield = "http://urldeclubes/escudo_gremio.png"
)

val matchItemApiResponseMocked = MatchItemApiResponse(
    championship = "Campeonato",
    stadium = "Estádio",
    shortDate = "01/03",
    completeDate = "01/03/2023",
    time = "16:00hrs ",
    channels = listOf("SporTV", "SBT", "YouTube"),
    teamHome = teamHomeApiResponseMocked,
    teamAway = teamAwayApiResponseMocked
)

val matchApiResponseMocked = MatchApiResponse(
    label = "Label",
    matches = listOf(
        matchItemApiResponseMocked
    )
)

val teamHomeModelMocked = TeamModel (
    shortName = "BAH",
    name = "Bahia",
    shield = "http://urldeclubes/escudo_bahia.png"
)

val teamAwayModelMocked = TeamModel (
    shortName = "GRM",
    name = "Gremio",
    shield = "http://urldeclubes/escudo_gremio.png"
)

val matchModelMocked = MatchModel(
    championship = "Campeonato",
    stadium = "Estádio",
    shortDate = "01/03",
    completeDate = "01/03/2023",
    time = "16:00hrs ",
    channels = listOf("SporTV", "SBT", "YouTube"),
    teamHome = teamHomeModelMocked,
    teamAway = teamAwayModelMocked
)

val matchModelListMocked = listOf(
    matchModelMocked
)



