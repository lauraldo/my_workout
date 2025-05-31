package com.niolasdev.myworkout.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.niolasdev.myworkout.ui.theme.Theme

@Composable
fun BottomNavBar(
    selectedScreen: UiBottomBarItem,
    onSelectScreen: (UiBottomBarItem) -> Unit,
    navController: NavHostController?,
) {

    val screens = listOf(
        UiBottomBarItem.Home,
        UiBottomBarItem.Exercises,
        UiBottomBarItem.Progress,
        UiBottomBarItem.Settings,
    )

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth(),
        containerColor = Theme.colors.secondary
    ) {
        screens.forEach { screen ->
            NavigationBarItem(
                selected = screen == selectedScreen,
                onClick = {
                    onSelectScreen.invoke(screen)
                    navController?.navigate(screen)
                },
                icon = {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(id = screen.icon),
                        contentDescription = null,
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = screen.title),
                    )
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedIconColor = Theme.colors.themeMain,
                    selectedTextColor = Theme.colors.themeMain,
                    unselectedIconColor = Theme.colors.textPrimary,
                    unselectedTextColor = Theme.colors.textSecondary,
                )
            )
        }
    }

}