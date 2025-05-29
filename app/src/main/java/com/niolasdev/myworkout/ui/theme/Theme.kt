package com.niolasdev.myworkout.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class ColorScheme(
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val accent: Color,
    val themeMain: Color,
//    val unselected: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,
)

val localColorScheme = staticCompositionLocalOf {
    ColorScheme(
        primary = Color.Unspecified,
        secondary = Color.Unspecified,
        tertiary = Color.Unspecified,
        accent = Color.Unspecified,
        themeMain = Color.Unspecified,
//        unselected = Color.Unspecified,
        textPrimary = Color.Unspecified,
        textSecondary = Color.Unspecified,
        textTertiary = Color.Unspecified,
    )
}

object Theme {
    val colors: ColorScheme
        @Composable get() = localColorScheme.current
}

@Composable
fun DefaultTheme(
    content: @Composable () -> Unit
) {
    val colors = ColorScheme(
        primary = Color(0xFF252F3B),
        secondary = Color(0xFF191F27),
        tertiary = Color(0xFF384555),
        accent = Color(0xFF44A8F2),
        themeMain = Color(0xFFFFDB13),
        textPrimary = Color(0xFFFFFFFF),
        textSecondary = Color(0xFFD3D3D3),
        textTertiary = Color(0xFF000000),
    )

    CompositionLocalProvider(
        localColorScheme provides colors,
        content = content,
    )
}