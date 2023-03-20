package br.com.futebolnatv.data.match.datasource.model
import com.squareup.moshi.Json

class MatchApiResponse (
    @Json(name = "label") var label: String,
    @Json(name = "jogos") var matches: List<MatchItemApiResponse>
)

class MatchItemApiResponse (
    @Json(name = "campeonato") var championship: String,
    @Json(name = "estadio") var stadium: String,
    @Json(name = "dataCurta") var shortDate: String,
    @Json(name = "dataCompleta") var completeDate: String,
    @Json(name = "horario") var time: String,
    @Json(name = "canaisTransmissao") var channels: List<String>,
    @Json(name = "visitante") var teamAway: TeamApiResponse,
    @Json(name = "casa") var teamHome: TeamApiResponse
)
