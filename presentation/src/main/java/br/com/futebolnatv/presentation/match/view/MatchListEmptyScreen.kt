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
fun MatchEmptyScreen(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    onClick: () -> Unit,
    tryAgain: Boolean
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = title,
            fontSize = 14.sp,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            text = description,
            fontSize = 12.sp,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
        if(tryAgain) {
            Button(
                onClick = { onClick() },
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Color.Black
                )) {
                Text("Limpar Filtros")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultMatchEmptyScreenPreview() {
    DSTheme {
        val  onClick : () -> Unit = {}
        MatchErrorScreen(
            title = "Tela Vazia",
            description = "Não foi encontrado nenhuam partida com esses filtros aplicados",
            tryAgain = true,
            onClick = onClick)
    }
}