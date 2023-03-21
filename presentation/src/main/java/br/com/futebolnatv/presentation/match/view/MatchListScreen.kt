package br.com.futebolnatv.presentation.match.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.futebolnatv.designsystem.theme.DSTheme
import br.com.futebolnatv.presentation.match.viewmodel.MatchViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.futebolnatv.presentation.match.state.MatchListState

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

    Column(verticalArrangement = Arrangement.spacedBy(24.dp))
    {
        when(val matchListState  = viewModel.matchListState.observeAsState().value) {

            is MatchListState.Success -> {
                MatchListContentScreen(
                    listMatchModel = matchListState.listMatch
                )
            }
            MatchListState.Empty -> {
                MatchErrorScreen(
                    title = "Tela Vazia",
                    description = "Não foi encontrado nenhuam partida com esses filtros aplicados",
                    tryAgain = true,
                    onClick = onClickClearFilter)
            }
            is MatchListState.Error -> {
                MatchErrorScreen(
                    title = matchListState.title,
                    description = matchListState.description,
                    tryAgain = matchListState.tryAgain,
                    onClick = onClickTryAgain
                )
            }
            else -> {
                MatchLoadingScreen()
            }
        }

    }

}



