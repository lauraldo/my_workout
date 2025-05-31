package com.niolasdev.myworkout.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun WorkoutScreen(
    viewModel: WorkoutViewModel = hiltViewModel<WorkoutViewModel>(),
    modifier: Modifier = Modifier,
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getWorkoutData()
    }

    WorkoutScreen(
        uiState = state,
        modifier = modifier,
    )

}

@Composable
internal fun WorkoutScreen(
    uiState: WorkoutUiState,
    modifier: Modifier,
) {

}