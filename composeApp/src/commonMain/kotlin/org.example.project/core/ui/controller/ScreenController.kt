package org.example.project.core.ui.controller

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface ScreenController<STATE, ACTION, EFFECT> {
    val effect: SharedFlow<EFFECT>
    val uiState: StateFlow<STATE>

    suspend fun setEffect(effect: EFFECT)
    fun setState(uiState: STATE)
    fun action(action: ACTION)
}