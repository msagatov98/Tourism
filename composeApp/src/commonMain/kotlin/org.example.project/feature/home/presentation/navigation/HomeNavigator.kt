package org.example.project.feature.home.presentation.navigation

import androidx.navigation.NavController
import org.example.project.core.ui.screen.Screen
import org.example.project.feature.home.presentation.model.Pokemon

class HomeNavigator(
    private val navController: NavController,
) {

    fun navigateUp() {
        navController.navigateUp()
    }

    fun goToDetails(pokemon: Pokemon) {
        navController.navigate(Screen.HomeDetail(pokemon.name, pokemon.imageUrl))
    }
}