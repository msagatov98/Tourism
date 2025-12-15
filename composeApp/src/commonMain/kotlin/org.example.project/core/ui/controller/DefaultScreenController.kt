package org.example.project.core.ui.controller

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DefaultScreenController<STATE, ACTION, EFFECT>(
    state: STATE,
) : ScreenController<STATE, ACTION, EFFECT> {

    private val _effect = MutableSharedFlow<EFFECT>()
    override val effect: SharedFlow<EFFECT> = _effect.asSharedFlow()

    private val _uiState = MutableStateFlow(state)
    override val uiState: StateFlow<STATE> = _uiState.asStateFlow()

    override fun action(action: ACTION) { }

    override fun setState(uiState: STATE) {
        _uiState.update { uiState }
    }

    override suspend fun setEffect(effect: EFFECT) {
        _effect.emit(effect)
    }
}