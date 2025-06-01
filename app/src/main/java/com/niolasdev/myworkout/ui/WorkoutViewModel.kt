package com.niolasdev.myworkout.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.niolasdev.myworkout.data.Filter
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
) : ViewModel() {

    private val LOG_TAG = this::class.simpleName ?: "VM"

    private val _state = MutableStateFlow<WorkoutUiState>(WorkoutUiState.Loading)

    val uiState: StateFlow<WorkoutUiState>
        get() = _state.asStateFlow()

    fun getWorkoutData() {
        viewModelScope.launch(Dispatchers.IO) {
            val workoutData = workoutRepository.getWorkoutData()
            _state.value = when (workoutData) {
                is WorkoutResult.Error -> {
                    Log.d(LOG_TAG, workoutData.e?.message ?: "error")
                    WorkoutUiState.Error(workoutData.e?.message ?: "")
                }

                is WorkoutResult.Success -> {
                    Log.d(LOG_TAG, workoutData.data.workouts[0].workout[0].exerciseName)
                    WorkoutUiState.Ready(
                        WorkoutUiData(
                            workoutData = workoutData.data,
                            filters = workoutRepository.getFilters()
                        )
                    )
                }
            }
        }
    }
}

data class WorkoutUiData(
    val workoutData: WorkoutData,
    val filters: List<Filter>
)

sealed interface WorkoutUiState {
    object Loading : WorkoutUiState
    data class Ready(val data: WorkoutUiData) : WorkoutUiState
    class Error(val message: String) : WorkoutUiState
}