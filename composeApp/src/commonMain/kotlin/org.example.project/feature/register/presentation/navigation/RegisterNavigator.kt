package org.example.project.feature.register.presentation.navigation

import androidx.navigation.NavController
import org.example.project.core.ui.screen.Screen

class RegisterNavigator(
    private val navController: NavController,
) {

    fun toHome() {
        navController.navigate(Screen.Home)
    }
}