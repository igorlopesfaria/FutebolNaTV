package br.com.futebolnatv.data.match.mapper

import br.com.futebolnatv.data.match.datasource.model.TeamApiResponse
import javax.inject.Inject

interface TeamMapper {
    fun map(apiResponse: TeamApiResponse): br.com.futebolnatv.model.TeamModel
}

class TeamMapperImpl @Inject constructor() : TeamMapper {
    override fun  map(apiResponse: TeamApiResponse) = br.com.futebolnatv.model.TeamModel(
        shortName = apiResponse.shortName,
        name = apiResponse.name,
        shield = apiResponse.shield
    )
}
