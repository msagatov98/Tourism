package org.example.project.feature.login.presentation.screen

sealed interface LoginAction {
    data object OnCloseClick : LoginAction
    data object OnLoginClick : LoginAction
    data object OnCreateAccountClick : LoginAction
    data object OnForgetPasswordClick : LoginAction
    data class OnEmailValueChanged(val value: String) : LoginAction
    data class OnPasswordValueChanged(val value: String) : LoginAction
}