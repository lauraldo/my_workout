package com.niolasdev.myworkout.data

import kotlinx.serialization.Serializable

@Serializable
data class WorkoutData(
    val workouts: List<WorkoutDay>,
) {
    val currentWeek: Int
        get() = 1

    val currentWeekName: String
        get() = "Foundations"

    val weekCount: Int
        get() = 5
}