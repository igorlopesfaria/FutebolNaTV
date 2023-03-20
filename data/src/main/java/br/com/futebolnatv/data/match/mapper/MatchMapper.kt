package br.com.futebolnatv.data.match.mapper

import br.com.futebolnatv.data.match.datasource.model.MatchItemApiResponse
import br.com.futebolnatv.model.MatchModel
import javax.inject.Inject

interface MatchMapper {
    fun mapToDomainModel(response: MatchItemApiResponse): MatchModel
}

class MatchMapperImpl @Inject constructor(
    private val teamMapper: TeamMapper
) : MatchMapper {
    override fun mapToDomainModel(response: MatchItemApiResponse) = MatchModel(
        championship = response.championship,
        stadium = response.stadium,
        shortDate = response.shortDate,
        completeDate = response.completeDate,
        time = response.time,
        channels = response.channels,
        teamAway = teamMapper.map(response.teamAway),
        teamHome = teamMapper.map(response.teamHome),
    )
}

