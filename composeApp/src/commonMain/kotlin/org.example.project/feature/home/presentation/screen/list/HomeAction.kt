package org.example.project.feature.home.presentation.screen.list

import org.example.project.feature.home.presentation.model.Pokemon

sealed interface HomeAction {
    data object OnBackClick : HomeAction
    data class OnPokemonClick(val pokemon: Pokemon) : HomeAction
}