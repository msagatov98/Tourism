package org.example.project.feature.start.presentation.screen

sealed interface StartAction {
    data object OnLoginClick : StartAction
    data object OnCreateAccountClick : StartAction
}