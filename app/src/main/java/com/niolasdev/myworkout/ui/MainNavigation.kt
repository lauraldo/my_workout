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
            WorkoutScreen(modifier = modifier)
        }
        composable<UiBottomBarItem.Exercises> {
            EmptyScreen(modifier = modifier)
        }
        composable<UiBottomBarItem.Progress> {
            EmptyScreen(modifier = modifier)
        }
        composable<UiBottomBarItem.Settings> {
            EmptyScreen(modifier = modifier)
        }
    }
}