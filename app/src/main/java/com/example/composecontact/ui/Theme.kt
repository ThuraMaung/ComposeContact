package com.example.composecontact.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = purple200,
    primaryVariant = purple700,
    secondary = teal200
)

private val LightColorPalette = lightColors(

    primary = Color.White,
    primaryVariant = Color.White,
    onPrimary = Color.Black,

    secondary = lightBlue500,
    onSecondary = Color.White,
//
//    background = Color.White,
//    onBackground = Color.Black,
//    surface = Color.White,
//    onSurface = Color.Black

)

@Composable
fun ComposeContactTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (true) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content,
    )
}