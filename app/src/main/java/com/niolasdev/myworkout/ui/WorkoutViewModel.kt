package com.niolasdev.myworkout.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.niolasdev.myworkout.data.WorkoutData
import com.niolasdev.myworkout.domain.WorkoutRepository
import com.niolasdev.myworkout.domain.WorkoutResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkoutViewModel @Inject constructor(
    private val workoutRepository: WorkoutRepository,
): ViewModel() {

    private val LOG_TAG = this::class.simpleName ?: "VM"

    private val _state = MutableStateFlow<WorkoutUiState>(WorkoutUiState.Loading)

    val uiState: StateFlow<WorkoutUiState>
        get() = _state.asStateFlow()

    fun getWorkoutData() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = workoutRepository.getWorkoutData()
            _state.value = when (result) {
                is WorkoutResult.Error -> {
                    Log.d(LOG_TAG, result.e?.message ?: "error")
                    WorkoutUiState.Error(result.e?.message ?: "")
                }
                is WorkoutResult.Success -> {
                    Log.d(LOG_TAG, result.data.workouts[0].workout[0].exerciseName)
                    WorkoutUiState.Data(result.data)
                }
            }
        }
    }
}

sealed interface WorkoutUiState {
    object Loading: WorkoutUiState
    data class Data(val workoutData: WorkoutData): WorkoutUiState
    class Error(val message: String): WorkoutUiState
}