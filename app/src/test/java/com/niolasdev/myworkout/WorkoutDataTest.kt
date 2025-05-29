package com.niolasdev.myworkout

import com.niolasdev.myworkout.data.Exercise
import com.niolasdev.myworkout.data.WorkoutData
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import java.io.File

class WorkoutDataTest {

    private val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
        prettyPrint = true
    }

    private fun readJsonFromFile(filePath: String): String {
        val file = File(filePath)
        return file.readText()
    }

    @Test
    fun `workout data deserialized correctly`() = runTest {
        val jsonData = readJsonFromFile("src/test/resources/workouts.json")

        val parsedData = json.decodeFromString<WorkoutData>(jsonData)

        assertNotNull(parsedData.workouts)
        assertEquals(4, parsedData.workouts.size)
    }

    @Test
    fun `exercise parsed correctly`() {
        val jsonData = readJsonFromFile("src/test/resources/workouts.json")

        val parsedData = json.decodeFromString<WorkoutData>(jsonData)

        val exercise = Exercise(
            exerciseId = 1,
            exerciseName = "Single Leg Extension",
            exerciseThumbnail = "exc_t_159_ronals.jpg",
            muscleGroup = "Legs",
            muscleGroupImage = "Muscle Groups 1.png",
            setsAmount = 3,
            repRange = "10-12",
            weightAmount = 8.0,
        )

        assertEquals(exercise, parsedData.workouts[0].workout[0])
    }

    @Test
    fun `exercise with null weight parsed correctly`() {
        val jsonData = readJsonFromFile("src/test/resources/workouts.json")

        val parsedData = json.decodeFromString<WorkoutData>(jsonData)

        val exercise = Exercise(
            exerciseId = 2,
            exerciseName = "Bodyweight Quadruped Glute Kick Back",
            exerciseThumbnail = "exc_t_153_ronals.jpg",
            muscleGroup = "Glutes",
            muscleGroupImage = "Muscle Groups 3.png",
            setsAmount = 5,
            repRange = "10-12",
            weightAmount = null
        )

        assertEquals(exercise, parsedData.workouts[0].workout[1])
    }
}