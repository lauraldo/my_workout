package com.niolasdev.myworkout.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel<MainViewModel>()
) {
    MainScreen(
        selectedScreen = viewModel.selectedScreen,
        onSelectScreen = { screen: UiBottomBarItem ->
            viewModel.onEvent(StartUiEvent.SelectScreen(screen))
        },
        modifier = modifier,
    )
}

@Composable
internal fun MainScreen(
    selectedScreen: UiBottomBarItem,
    modifier: Modifier = Modifier,
    onSelectScreen: (UiBottomBarItem) -> Unit = {},
) {
    val navController = rememberNavController()

    Scaffold(
        containerColor = Color.Transparent,
        modifier = modifier,
        content = @Composable { innerPadding ->
            MainNavigation(
                navController = navController,
                modifier = modifier.padding(innerPadding)
            )
        },
        bottomBar = {
            BottomNavBar(
                selectedScreen = selectedScreen,
                onSelectScreen = onSelectScreen,
                navController = navController,
            )
        },
    )
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(selectedScreen = UiBottomBarItem.Home)
}