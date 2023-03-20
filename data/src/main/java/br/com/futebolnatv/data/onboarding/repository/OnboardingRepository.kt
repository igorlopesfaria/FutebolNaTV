package br.com.futebolnatv.data.onboarding.repository

import br.com.futebolnatv.data.onboarding.datasource.OnboardingLocalDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface OnboardingRepository {
    suspend fun isFirstAccess(): Flow<Boolean>
    suspend fun insertFirstAccess(isFirstAccess: Boolean): Flow<Boolean>
}

class OnboardingRepositoryImpl @Inject constructor(
    private val localDataSource: OnboardingLocalDataSource
) : OnboardingRepository {

    override suspend fun isFirstAccess() = flow {
        emit(localDataSource.isFirstTime())
    }.flowOn(Dispatchers.IO)

    override suspend fun insertFirstAccess(isFirstAccess: Boolean) = flow {
        localDataSource.insertFirstTime(isFirstAccess)
        emit(true)
    }.flowOn(Dispatchers.IO)

}

