package br.com.futebolnatv.presentation.match.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.futebolnatv.designsystem.theme.DSTheme
import br.com.futebolnatv.presentation.match.viewmodel.MatchViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.futebolnatv.model.MatchModel

@Composable
fun MatchListContentScreen(
    modifier: Modifier = Modifier,
    listMatchModel: List<MatchModel>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp)
    )
    {
        Text(
            text = "Tela de Partidas",
            fontSize = 45.sp,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MatchListContentPreview() {
    DSTheme {
        MatchListContentScreen(listMatchModel = emptyList())
    }
}



