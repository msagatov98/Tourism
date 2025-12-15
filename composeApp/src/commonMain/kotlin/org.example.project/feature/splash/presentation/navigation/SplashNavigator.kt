package org.example.project.feature.splash.presentation.navigation

import androidx.navigation.NavController
import org.example.project.core.ui.screen.Screen

class SplashNavigator(
    private val navController: NavController,
) {

    fun toStart() {
        navController.navigate(Screen.Start) {
            popUpTo(Screen.Splash) {
                inclusive = true
            }
        }
    }
}