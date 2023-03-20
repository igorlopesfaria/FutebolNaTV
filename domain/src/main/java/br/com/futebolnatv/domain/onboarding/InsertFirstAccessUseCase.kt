package br.com.futebolnatv.domain.onboarding

import br.com.futebolnatv.commons.model.UseCase
import br.com.futebolnatv.data.onboarding.repository.OnboardingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InsertFirstAccessUseCase @Inject constructor(private val repository: OnboardingRepository,): UseCase<Boolean, Flow<Boolean>> {
    override suspend fun invoke(param: Boolean?): Flow<Boolean> = repository.insertFirstAccess(param ?: false)
}