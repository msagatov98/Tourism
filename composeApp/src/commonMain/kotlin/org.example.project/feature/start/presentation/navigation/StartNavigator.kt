package org.example.project.feature.start.presentation.navigation

import androidx.navigation.NavController
import org.example.project.core.ui.screen.Screen

class StartNavigator(
    private val navController: NavController,
) {

    fun toLogin() {
        navController.navigate(Screen.Login)
    }

    fun toRegister() {
        navController.navigate(Screen.Register)
    }
}