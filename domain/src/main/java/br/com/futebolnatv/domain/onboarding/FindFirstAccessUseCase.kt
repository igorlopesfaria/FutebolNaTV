package br.com.futebolnatv.domain.onboarding

import br.com.futebolnatv.commons.model.UseCase
import br.com.futebolnatv.data.onboarding.repository.OnboardingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FindFirstAccessUseCase @Inject constructor(private val repository: OnboardingRepository): UseCase<Void, Flow<Boolean>> {
    override suspend fun invoke(param: Void?): Flow<Boolean> = repository.isFirstAccess()
}