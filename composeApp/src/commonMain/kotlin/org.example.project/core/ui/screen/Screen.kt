package org.example.project.core.ui.screen

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen {

    @Serializable data object Home : Screen
    @Serializable data object About : Screen
    @Serializable data object Start : Screen
    @Serializable data object Login : Screen
    @Serializable data object Splash : Screen
    @Serializable data object Register : Screen
    @Serializable data object Settings : Screen
    @Serializable data object RestorePassword : Screen

    @Serializable data class HomeDetail(
        val pokemonName: String,
        val imageUrl: String,
    ) : Screen
}
