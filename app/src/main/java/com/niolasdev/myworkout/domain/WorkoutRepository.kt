package com.niolasdev.myworkout.domain

import com.niolasdev.myworkout.data.WorkoutData

interface WorkoutRepository {

    suspend fun getWorkoutData(): WorkoutResult<WorkoutData>
}