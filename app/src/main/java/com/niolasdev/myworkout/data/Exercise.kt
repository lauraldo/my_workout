package com.niolasdev.myworkout.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Exercise(
    @SerialName("exercise_id") val exerciseId: Int,
    @SerialName("exercise_name") val exerciseName: String,
    @SerialName("exercise_thumbnail") val exerciseThumbnail: String,
    @SerialName("muscle_group") val muscleGroup: String,
    @SerialName("muscle_group_image") val muscleGroupImage: String,
    @SerialName("amount_of_sets") val setsAmount: Int,
    @SerialName("rep_range") val repRange: String,
    @SerialName("weight_amount") val weightAmount: Double?,
) {
    val weightLbs: Int
        get() = ((weightAmount ?: 0.0) * 2.2).toInt()
}