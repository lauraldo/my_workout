package com.niolasdev.myworkout.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.niolasdev.myworkout.R
import com.niolasdev.myworkout.ui.theme.DefaultTheme
import com.niolasdev.myworkout.ui.theme.Theme
import com.niolasdev.myworkout.ui.widget.ActionButton
import com.niolasdev.myworkout.ui.widget.ControlSwitch
import com.niolasdev.myworkout.ui.widget.ExerciseHeaderItem
import com.niolasdev.myworkout.ui.widget.ExerciseItem
import com.niolasdev.myworkout.ui.widget.FilterButton

@Composable
fun WorkoutScreen(
    viewModel: WorkoutViewModel = hiltViewModel<WorkoutViewModel>(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getWorkoutData()
    }

    WorkoutScreen(
        uiState = state,
    )

}

@Composable
internal fun WorkoutScreen(
    uiState: WorkoutUiState,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
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

                with(uiState.data) {

                    LazyRow(
                        contentPadding = PaddingValues(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(filters) { filter ->
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
                        itemsIndexed(workoutData.workouts) { index, workoutDay ->
                            ControlSwitch(
                                selected = index == selectedDay.intValue,
                                onSelect = {
                                    selectedDay.intValue = index
                                },
                            ) {
                                if (workoutDay.isCompleted) {
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

                    Spacer(Modifier.height(16.dp))


                    Box(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Column(
                            modifier = Modifier.align(Alignment.Center),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                text = "Week ${workoutData.currentWeek}/${workoutData.weekCount} " +
                                        "- ${workoutData.currentWeekName}",
                                color = Theme.colors.accent
                            )
                            Text(
                                text = if (workoutData.workouts[selectedDay.intValue].isCompleted)
                                    "WORKOUT COMPLETED" else "UPCOMING WORKOUT",
                                color = Theme.colors.textPrimary,
                                style = Theme.fonts.important,
                            )
                            Text(
                                text = workoutData.workouts[selectedDay.intValue].nextExerciseName,
                                color = Theme.colors.textSecondary,
                            )
                        }
                        FilledIconButton(
                            modifier = Modifier.align(Alignment.CenterEnd),
                            onClick = {},
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = if (workoutData.workouts[selectedDay.intValue].isCompleted)
                                    Color.Transparent
                                else
                                    Theme.colors.secondary,
                            ),
                            shape = RoundedCornerShape(8.dp),
                        ) {
                            Icon(
                                modifier = Modifier.size(16.dp),
                                painter = painterResource(
                                    if (workoutData.workouts[selectedDay.intValue].isCompleted)
                                        R.drawable.ic_share
                                    else
                                        R.drawable.ic_pen
                                ),
                                tint = Theme.colors.textPrimary,
                                contentDescription = null,
                            )
                        }
                    }

                    Spacer(Modifier.height(16.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 8.dp)
                            .background(
                                color = Theme.colors.secondary,
                                shape = RoundedCornerShape(8.dp)
                            ),
                    ) {
                        LazyColumn(
                            contentPadding = PaddingValues(all = 8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            item {
                                ExerciseHeaderItem(workoutData.workouts[selectedDay.intValue])
                            }

                            items(workoutData.workouts[selectedDay.intValue].workout) { exercise ->
                                ExerciseItem(exercise)
                            }

                            // Hack for button overscroll
                            item {
                                Spacer(Modifier.height(80.dp))
                            }
                        }
                        ActionButton(
                            text = if (workoutData.workouts[selectedDay.intValue].isCompleted)
                                "REDO WORKOUT"
                            else
                                "START WORKOUT",
                            onClick = {},
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(horizontal = 48.dp, vertical = 16.dp)
                                .shadow(8.dp, shape = RoundedCornerShape(16.dp))
                                .fillMaxWidth()
                        )
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