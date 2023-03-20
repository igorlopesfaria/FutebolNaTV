package br.com.futebolnatv.domain.match

import br.com.futebolnatv.commons.model.UseCase
import br.com.futebolnatv.data.match.repository.MatchRepository
import br.com.futebolnatv.model.MatchModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FindAllMatchUseCase @Inject constructor(private val repository: MatchRepository): UseCase<Void, Flow<List<MatchModel>>> {
    override suspend fun invoke(param: Void?): Flow<List<MatchModel>> = repository.getMatches()
}