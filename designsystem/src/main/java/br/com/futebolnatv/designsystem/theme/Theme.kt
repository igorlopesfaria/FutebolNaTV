package br.com.futebolnatv.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
    primary = Indigo200,
    secondary = Light_blue200,
    onSecondary = Black,
    onPrimary = Black,
    onBackground = White,
    onSurface = White,
    background = Black,
    surface = Black,
    error = Red400
)

private val LightColorPalette = lightColorScheme(
    primary = Indigo500,
    secondary = Light_blue200,
    onSecondary = Black,
    onPrimary = White,
    onBackground = Black,
    onSurface = Black,
    background = White,
    surface = White,
    error = Red700
)

@Composable
fun DSTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}