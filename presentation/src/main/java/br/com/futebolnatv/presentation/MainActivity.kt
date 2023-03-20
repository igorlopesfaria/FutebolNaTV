package br.com.futebolnatv.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import br.com.futebolnatv.designsystem.theme.DSTheme
import br.com.futebolnatv.presentation.match.view.MatchListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DSTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MatchListScreen()
                }
            }
        }
    }
}
