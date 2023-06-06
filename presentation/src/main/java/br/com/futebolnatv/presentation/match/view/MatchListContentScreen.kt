package br.com.futebolnatv.presentation.match.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ds.helium.core.HeliumTheme
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
    HeliumTheme {
        MatchListContentScreen(listMatchModel = emptyList())
    }
}



