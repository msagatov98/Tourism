package org.example.project.feature.settings.presentation.model

import androidx.compose.runtime.Immutable
import org.jetbrains.compose.resources.StringResource

@Immutable
data class TextFieldData(
    val value: String,
    val labelRes: StringResource,
)
