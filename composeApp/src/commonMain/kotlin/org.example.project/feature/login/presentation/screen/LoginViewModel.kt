package org.example.project.feature.login.presentation.screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import org.example.project.core.ui.controller.DefaultScreenController
import org.example.project.core.ui.controller.ScreenController
import org.example.project.core.util.ext.launch
import org.example.project.core.util.result.onSuccess
import org.example.project.feature.login.data.repository.LoginRepository
import org.example.project.feature.login.presentation.navigation.LoginNavigator

class LoginViewModel(
    private val loginNavigator: LoginNavigator,
    private val loginRepository: LoginRepository,
) : ViewModel(),
    ScreenController<LoginUIState, LoginAction, LoginEffect> by DefaultScreenController(
        LoginUIState()
    ) {

    override fun action(action: LoginAction) {
        when (action) {
            LoginAction.OnLoginClick -> onLoginClick()
            LoginAction.OnForgetPasswordClick -> loginNavigator.toRestorePassword()
            is LoginAction.OnEmailValueChanged -> setState(uiState.value.copy(email = action.value))
            is LoginAction.OnPasswordValueChanged -> setState(uiState.value.copy(password = action.value))
            LoginAction.OnCloseClick -> loginNavigator.close()
            LoginAction.OnCreateAccountClick -> loginNavigator.toCreateAccount()
        }
    }

    private fun onLoginClick() = launch {
        setState(uiState = uiState.value.copy(isLoading = true))
        delay(1000)
        loginRepository.login(uiState.value.email, uiState.value.password)
            .onSuccess { loginNavigator.toHome() }
            .also { setState(uiState = uiState.value.copy(isLoading = false)) }
    }
}
