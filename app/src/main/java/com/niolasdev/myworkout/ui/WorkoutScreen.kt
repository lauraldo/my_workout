package com.niolasdev.myworkout.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.niolasdev.myworkout.R
import com.niolasdev.myworkout.ui.theme.DefaultTheme
import com.niolasdev.myworkout.ui.theme.Theme
import com.niolasdev.myworkout.ui.widget.ControlSwitch
import com.niolasdev.myworkout.ui.widget.FilterButton

@Composable
fun WorkoutScreen(
    modifier: Modifier = Modifier,
    viewModel: WorkoutViewModel = hiltViewModel<WorkoutViewModel>(),
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
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {

        Text(
            modifier = Modifier.padding(8.dp),
            text = "My Workout",
            color = Theme.colors.textPrimary,
            style = Theme.fonts.title
        )
        HorizontalDivider(color = Theme.colors.tertiary)

        when (uiState) {
            is WorkoutUiState.Error -> {}
            WorkoutUiState.Loading -> {}
            is WorkoutUiState.Ready -> {
                LazyRow(
                    contentPadding = PaddingValues(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(uiState.data.filters) { filter ->
                        FilterButton(
                            onClick = {}
                        ) {
                            Text(text = filter.name, color = Theme.colors.textPrimary)
                            Spacer(modifier = Modifier.width(12.dp))
                            Icon(
                                modifier = Modifier.size(16.dp),
                                painter = painterResource(
                                    if (filter.isRefreshing)
                                        R.drawable.ic_refresh
                                    else
                                        R.drawable.ic_chevron_down
                                ),
                                contentDescription = null,
                                tint = Theme.colors.textPrimary
                            )
                        }
                    }
                }

                val selectedDay = remember {
                    mutableIntStateOf(0)
                }

                LazyRow(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    contentPadding = PaddingValues(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    itemsIndexed (uiState.data.workoutData.workouts) { index, workoutDay ->
                        ControlSwitch(
                            selected = index == selectedDay.intValue,
                            onSelect = {
                                selectedDay.intValue = index
                            },
                        ) {
                            if (workoutDay.day == 2) {
                                Icon(
                                    modifier = Modifier.size(16.dp),
                                    painter = painterResource(R.drawable.ic_check),
                                    contentDescription = null,
                                    tint = Theme.colors.accent,
                                )
                            } else {
                                Text(
                                    text = "Day ${workoutDay.day}",
                                    color = Theme.colors.accent,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun WorkoutScreenPreview() {
    DefaultTheme {
        WorkoutScreen(uiState = WorkoutUiState.Loading)
    }
}