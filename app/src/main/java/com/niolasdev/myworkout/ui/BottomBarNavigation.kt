package com.niolasdev.myworkout.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomBarNavigation(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = UiBottomBarItem.Home.route) {
        composable(UiBottomBarItem.Home.route) {
            WorkoutScreen()
        }
        composable(UiBottomBarItem.Exercises.route) {
            EmptyScreen()
        }
        composable(UiBottomBarItem.Progress.route) {
            EmptyScreen()
        }
        composable(UiBottomBarItem.Settings.route) {
            EmptyScreen()
        }
    }
}