package com.niolasdev.myworkout.domain

import com.niolasdev.myworkout.data.Filter
import com.niolasdev.myworkout.data.WorkoutData

interface WorkoutRepository {

    suspend fun getWorkoutData(): WorkoutResult<WorkoutData>
    suspend fun getFilters(): List<Filter>
}