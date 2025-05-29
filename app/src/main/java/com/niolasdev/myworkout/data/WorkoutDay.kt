package com.niolasdev.myworkout.data

import kotlinx.serialization.Serializable

@Serializable
data class WorkoutDay(
    val day: Int,
    val workout: List<Exercise>,
)