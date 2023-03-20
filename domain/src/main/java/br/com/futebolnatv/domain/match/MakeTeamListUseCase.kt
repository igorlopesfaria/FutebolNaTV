package br.com.futebolnatv.domain.match

import br.com.futebolnatv.commons.model.UseCase
import br.com.futebolnatv.model.MatchModel
import javax.inject.Inject

class MakeTeamListUseCase @Inject constructor(): UseCase<List<MatchModel>, List<String>> {

    override suspend fun invoke(param: List<MatchModel>?): List<String> {
        val teamLists: MutableList<String> = mutableListOf()
        param?.let {
            for (matchModel in param) {
                if (!teamLists.contains(matchModel.teamHome.name)) {
                    teamLists.add(matchModel.teamHome.name)
                }
                if (!teamLists.contains(matchModel.teamAway.name)) {
                    teamLists.add(matchModel.teamAway.name)
                }
            }
            teamLists.sort()
            teamLists.add(0, "Todos")
        }
        return teamLists
    }
}