package org.example.project.feature.register.presentation.screen

sealed interface RegisterAction {
    class OnInputEmail(val value: String) : RegisterAction
    data object OnRegisterClicked : RegisterAction
}