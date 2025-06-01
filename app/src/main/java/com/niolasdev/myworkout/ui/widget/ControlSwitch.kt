package com.niolasdev.myworkout.ui.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.niolasdev.myworkout.R
import com.niolasdev.myworkout.ui.theme.DefaultTheme
import com.niolasdev.myworkout.ui.theme.Theme

@Composable
fun ControlSwitch(
    selected: Boolean,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onSelect,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected)
                Theme.colors.secondary
            else
                Theme.colors.tertiary
        ),
        elevation = ButtonDefaults.elevatedButtonElevation(
            if (selected)
                Theme.elevation.pressed
            else
                Theme.elevation.default
        ),
        content = content,
    )
}

@Preview
@Composable
fun ControlSwitchesPreview() {
    DefaultTheme {
        Row {
            ControlSwitch(true, {}) {
                Text(
                    text = "Selected",
                    color = Theme.colors.accent
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            ControlSwitch(false, {}) {
                Text(
                    text = "Unselected",
                    color = Theme.colors.accent
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            ControlSwitch(false, {}) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(R.drawable.ic_check),
                    contentDescription = null,
                    tint = Theme.colors.accent,
                )
            }
        }
    }
}