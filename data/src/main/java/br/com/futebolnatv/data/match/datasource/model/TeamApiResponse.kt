package br.com.futebolnatv.data.match.datasource.model
import com.squareup.moshi.Json

data class TeamApiResponse(
    @Json(name = "abreviacao") var shortName: String,
    @Json(name = "nome") var name: String,
    @Json(name = "urlEscudo") var shield: String
)