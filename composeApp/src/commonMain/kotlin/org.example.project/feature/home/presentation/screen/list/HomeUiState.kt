package org.example.project.feature.home.presentation.screen.list

import androidx.compose.runtime.Immutable
import org.example.project.core.ui.component.ScreenState
import org.example.project.feature.home.presentation.model.Pokemon

@Immutable
data class HomeUiState(
    val screenState: ScreenState = ScreenState.Loading,
    val pokemons: List<Pokemon> = emptyList(),
)
