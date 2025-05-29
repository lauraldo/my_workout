package com.niolasdev.myworkout.domain

sealed class WorkoutResult<T> {
    data class Error<T>(val e: Throwable?): WorkoutResult<T>()
    data class Success<T>(val data: T): WorkoutResult<T>()
}