package br.com.futebolnatv.domain.match

import br.com.futebolnatv.commons.model.UseCase
import br.com.futebolnatv.model.MatchModel
import javax.inject.Inject

class MakeChampionshipListUseCase @Inject constructor(): UseCase<List<MatchModel>, List<String>> {

    override suspend fun invoke(param: List<MatchModel>?): List<String> {
        val championshipLists: MutableList<String> = mutableListOf()
        param?.let {
            for (matchModel in param) {
                if (!championshipLists.contains(matchModel.championship)) {
                    championshipLists.add(matchModel.championship)
                }
            }

            championshipLists.sort()
            championshipLists.add(0, "Todos")
        }

        return championshipLists
    }
}