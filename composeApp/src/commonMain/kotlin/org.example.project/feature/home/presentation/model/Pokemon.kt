package org.example.project.feature.home.presentation.model

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class Pokemon(
    val name: String,
    val imageUrl: String,
)
