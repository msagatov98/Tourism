package org.example.project.feature.login.presentation.screen

import androidx.compose.runtime.Immutable
import org.example.project.core.util.ext.empty

@Immutable
data class LoginUIState(
    val isLoading: Boolean = false,
    val email: String = String.empty,
    val password: String = String.empty,
)
