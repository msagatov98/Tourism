package org.example.project.feature.register.presentation.screen

import androidx.compose.runtime.Immutable
import org.example.project.core.util.ext.empty

@Immutable
data class RegisterUiState(
    val name: String = String.empty,
    val email: String = String.empty,
    val phone: String = String.empty,
    val language: String = String.empty,
    val country: String = String.empty,
    val loading: Boolean = false,
)
