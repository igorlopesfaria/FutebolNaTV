package br.com.futebolnatv.data.match.repository

import br.com.futebolnatv.data.match.datasource.MatchApiDataSource
import br.com.futebolnatv.data.match.mapper.MatchMapper
import br.com.futebolnatv.model.MatchModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface MatchRepository {
    suspend fun getMatches(): Flow<List<MatchModel>>
}

class MatchRepositoryImpl @Inject constructor(
    private val apiDataSource: MatchApiDataSource,
    private val matchMapper: MatchMapper
) : MatchRepository {

    override suspend fun getMatches(): Flow<List<MatchModel>> = flow {
        emit(
            apiDataSource.getMatches().matches.map(
                matchMapper::mapToDomainModel
            )
        )
    }.flowOn(Dispatchers.IO)

}