package com.niolasdev.myworkout.ui.widget

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.niolasdev.myworkout.R
import com.niolasdev.myworkout.ui.theme.DefaultTheme
import com.niolasdev.myworkout.ui.theme.Theme

@Composable
fun FilterButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = ControlShape,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Theme.colors.secondary,
        ),
        shape = shape,
        contentPadding = PaddingValues(horizontal = 16.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = Theme.elevation.default,
            pressedElevation = Theme.elevation.pressed,
        ),
        enabled = true,
        modifier = modifier,
        onClick = onClick,
        content = content,
    )
}

val ControlShape = RoundedCornerShape(size = 28.dp)

@Preview(showBackground = true)
@Composable
fun FilterButtonPreview() {
    DefaultTheme {
        FilterButton(onClick = {}) {
            Text(text = "Muscles (16)", color = Theme.colors.textPrimary)
            Spacer(modifier = Modifier.width(12.dp))
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(R.drawable.ic_chevron_down),
                contentDescription = null,
                tint = Theme.colors.textPrimary
            )
        }
    }
}