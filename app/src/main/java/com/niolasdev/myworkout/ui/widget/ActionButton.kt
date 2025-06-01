package com.niolasdev.myworkout.ui.widget

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.niolasdev.myworkout.ui.theme.DefaultTheme
import com.niolasdev.myworkout.ui.theme.Theme

@Composable
fun ActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = Theme.elevation.default,
            pressedElevation = Theme.elevation.pressed,
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Theme.colors.themeMain,
        )
    ) {
        Text(
            text = text,
            style = Theme.fonts.important,
            color = Theme.colors.textTertiary,
            modifier = Modifier.padding(vertical = 4.dp)
        )
    }
}

@Preview
@Composable
fun ActionButtonPreview() {
    DefaultTheme {
        ActionButton("START WORKOUT", {})
    }
}