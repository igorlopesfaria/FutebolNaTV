package br.com.futebolnatv.data.match.datasource

import br.com.futebolnatv.data.match.datasource.model.MatchApiResponse
import retrofit2.http.GET

interface MatchApiDataSource {

    @GET("matches")
    suspend fun getMatches(): MatchApiResponse
}