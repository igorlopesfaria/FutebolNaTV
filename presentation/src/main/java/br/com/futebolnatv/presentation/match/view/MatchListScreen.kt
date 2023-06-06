package br.com.futebolnatv.presentation.match.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.ds.helium.statusview.HeliumStatusView
import br.com.ds.helium.statusview.HeliumStatusViewType
import br.com.futebolnatv.presentation.match.state.FilterMatchState
import br.com.futebolnatv.presentation.match.state.MatchListState
import br.com.futebolnatv.presentation.match.viewmodel.MatchViewModel

@Composable
fun MatchListScreen(
    viewModel: MatchViewModel = viewModel(),
) {

    val  onClickTryAgain : () -> Unit = {
        viewModel.findAllMatches()
    }

    val  onClickClearFilter : () -> Unit = {
        viewModel.findAllMatches()
    }

    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        when (val filterState  = viewModel.filterState.observeAsState().value) {
            is FilterMatchState.Loading -> {

            }
            else -> {
            }

        }
        when(val matchListState  = viewModel.matchListState.observeAsState().value) {

            is MatchListState.Success -> {
                MatchListContentScreen(
                    listMatchModel = matchListState.listMatch
                )
            }
            MatchListState.Empty -> {
                HeliumStatusView(
                    type = HeliumStatusViewType.Empty,
                    title = "Tela Vazia",
                    description = "Não foi encontrado nenhuam partida com esses filtros aplicados",
                )
            }
            is MatchListState.GenericError -> {
                HeliumStatusView(
                    type = HeliumStatusViewType.GenericError,
                    title = "Ops! Encontramos um problema",
                    description = "Não foi possível ter listagem de partidas",
                    onClick = onClickTryAgain
                )
            }
            is MatchListState.InternetError -> {
                HeliumStatusView(
                    type = HeliumStatusViewType.NoInternet,
                    title = "Tela Vazia",
                    description = "Não foi encontrado nenhuam partida com esses filtros aplicados",
                    onClick = onClickTryAgain
                )
            }
            else -> {
                MatchLoadingScreen()
            }
        }

    }

}



