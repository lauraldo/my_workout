package com.niolasdev.myworkout.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    var selectedScreen by mutableStateOf<UiBottomBarItem>(UiBottomBarItem.Home)
        private set

    fun onEvent(event: StartUiEvent) {
        when(event) {
            is StartUiEvent.SelectScreen -> updateSelectedScreen(event.screen)
        }
    }

    private fun updateSelectedScreen(screen: UiBottomBarItem) {
        viewModelScope.launch {
            selectedScreen = screen
        }
    }
}

sealed interface StartUiEvent {
    data class SelectScreen(val screen: UiBottomBarItem): StartUiEvent
}