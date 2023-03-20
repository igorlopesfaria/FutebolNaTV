package br.com.futebolnatv.domain.match

import br.com.futebolnatv.commons.model.UseCase
import br.com.futebolnatv.model.MatchModel
import javax.inject.Inject

class MakeDateListUseCase @Inject constructor(): UseCase<List<MatchModel>, List<String>> {

    override suspend fun invoke(param: List<MatchModel>?): List<String> {
        val dateMatchLists: MutableList<String> = mutableListOf()
        param?.let {
            for (matchModel in param) {
                if (!dateMatchLists.contains(matchModel.shortDate)) {
                    dateMatchLists.add(matchModel.shortDate)
                }
            }

            dateMatchLists.sort()
            dateMatchLists.add(0, "Todos")
        }
        return dateMatchLists
    }
}