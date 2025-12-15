package org.example.project.feature.settings.presentation.screen

import androidx.compose.runtime.Immutable
import org.example.project.feature.settings.presentation.model.TextFieldData

@Immutable
data class SettingsUiState(
    val data: Any = Any(),
    val fields: List<TextFieldData> = emptyList(),
)
