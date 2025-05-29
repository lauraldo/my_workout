package com.niolasdev.myworkout.domain

import android.content.Context
import com.niolasdev.myworkout.data.WorkoutData
import kotlinx.serialization.json.Json
import javax.inject.Inject

class WorkoutRepositoryImpl @Inject constructor(
    private val json: Json,
    private val context: Context,
) : WorkoutRepository {

    private fun readJsonFromAsset(fileName: String): String {
        context.assets.open(fileName).bufferedReader().use {
            return it.readText()
        }
    }

    override suspend fun getWorkoutData(): WorkoutResult<WorkoutData> {
        return try {
            val dataStr = readJsonFromAsset("workouts.json")
            val data = json.decodeFromString<WorkoutData>(dataStr)
            WorkoutResult.Success(data)
        } catch (e: Throwable) {
            WorkoutResult.Error(e)
        }
    }
}