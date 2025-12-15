package org.example.project.feature.login.presentation.navigation

import androidx.navigation.NavController
import org.example.project.core.ui.screen.Screen

class LoginNavigator(
    private val navController: NavController,
) {

    fun close() {
        navController.navigateUp()
    }

    fun toCreateAccount() {
        navController.navigate(Screen.Register)
    }

    fun toRestorePassword() {
        // todo
    }

    fun toHome() {
        navController.navigate(Screen.Home) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
        }
    }
}
