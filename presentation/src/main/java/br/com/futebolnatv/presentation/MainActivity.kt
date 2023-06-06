package br.com.futebolnatv.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.com.ds.helium.core.HeliumTheme
import br.com.futebolnatv.presentation.match.view.MatchListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HeliumTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MatchListScreen()
                }
            }
        }
    }
}
