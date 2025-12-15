package org.example.project.feature.register.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.example.project.core.ui.controller.DefaultScreenController
import org.example.project.core.ui.controller.ScreenController
import org.example.project.feature.register.presentation.navigation.RegisterNavigator

class RegisterViewModel(
    private val registerNavigator: RegisterNavigator,
) : ViewModel(),
    ScreenController<RegisterUiState, RegisterAction, RegisterEffect> by DefaultScreenController(
        RegisterUiState()
    ) {

    override fun action(action: RegisterAction) {
        when (action) {
            is RegisterAction.OnInputEmail -> setState(uiState = uiState.value.copy(email = action.value))
            RegisterAction.OnRegisterClicked -> onRegisterClicked()
        }
    }

    private fun onRegisterClicked() = viewModelScope.launch {
        setState(uiState = uiState.value.copy(loading = true))
        delay(1000)
        setState(uiState = uiState.value.copy(loading = false))
        registerNavigator.toHome()
    }
}