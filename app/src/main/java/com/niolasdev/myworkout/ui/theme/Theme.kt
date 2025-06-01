package com.niolasdev.myworkout.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.niolasdev.myworkout.R

@Immutable
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

@Immutable
data class Typography(
    val title: TextStyle,
    val important: TextStyle,
)

@Immutable
data class Elevation(
    val default: Dp,
    val pressed: Dp,
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

val localTypography = staticCompositionLocalOf {
    Typography(
        title = TextStyle.Default,
        important = TextStyle.Default,
    )
}

val workoutFontFamily = FontFamily(
    Font(R.font.lakes_neue_trial)
)

val localElevation = staticCompositionLocalOf {
    Elevation(
        default = Dp.Unspecified,
        pressed = Dp.Unspecified,
    )
}

object Theme {
    val colors: ColorScheme
        @Composable get() = localColorScheme.current
    val fonts: Typography
        @Composable get() = localTypography.current
    val elevation: Elevation
        @Composable get() = localElevation.current
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

    val typography = Typography(
        title = TextStyle(fontSize = 20.sp),
        important = TextStyle(
            fontFamily = workoutFontFamily,
            fontSize = 16.sp
        ),
    )

    val elevation = Elevation(
        default = 0.dp,
        pressed = 2.dp,
    )

    CompositionLocalProvider(
        localColorScheme provides colors,
        localTypography provides typography,
        localElevation provides elevation,
        content = content,
    )
}