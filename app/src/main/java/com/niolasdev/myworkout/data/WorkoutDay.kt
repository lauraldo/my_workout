package com.niolasdev.myworkout.data

import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
data class WorkoutDay(
    val day: Int,
    val workout: List<Exercise>,
) {
    val isCompleted: Boolean
        get() = day == 2

    val exerciseCount: Int
        get() = workout.size

    val durationMins: Int
        get() = (workout.size - 1) * 10 + 3

    val caloriesCount: Int
        get() = Random.nextInt(1, 300)

    val nextExerciseName: String
        get() = if (day % 2 == 0) "Pull" else "Push"
}