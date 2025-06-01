package com.niolasdev.myworkout.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = UiBottomBarItem.Home,
    ) {
        composable<UiBottomBarItem.Home> {
            WorkoutScreen()
        }
        composable<UiBottomBarItem.Exercises> {
            EmptyScreen()
        }
        composable<UiBottomBarItem.Progress> {
            EmptyScreen()
        }
        composable<UiBottomBarItem.Settings> {
            EmptyScreen()
        }
    }
}