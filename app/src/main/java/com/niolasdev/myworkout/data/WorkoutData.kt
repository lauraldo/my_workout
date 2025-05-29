package com.niolasdev.myworkout.data

import kotlinx.serialization.Serializable

@Serializable
data class WorkoutData(
    val workouts: List<WorkoutDay>,
)