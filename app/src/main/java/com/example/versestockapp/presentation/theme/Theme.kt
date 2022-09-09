package com.example.versestockapp.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Teal,
    primaryVariant = Teal_02,
    secondary = LightBlue,
    background = Teal,
    onBackground = LightBlue,
    onError = Red
)

private val LightColorPalette = lightColors(
    primary = Color.White,
    primaryVariant = LightBlue,
    secondary = Teal,
    background = Color.White,
    onBackground = Teal_02,
    onError = Red
)

@Composable
fun VerseStockAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}