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

@Composable
fun MatchLoadingScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp)
    )
    {
        Text(
            text = "Carregando Tela de Jogos",
            fontSize = 12.sp,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
    }
}



@Preview(showBackground = true)
@Composable
fun MatchDefaultPreview() {
    DSTheme {
        MatchLoadingScreen()
    }
}