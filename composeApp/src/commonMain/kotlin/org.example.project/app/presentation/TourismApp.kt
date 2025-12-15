package org.example.project.app.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.compose.setSingletonImageLoaderFactory
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.request.crossfade
import okio.FileSystem
import org.example.project.core.ui.screen.Screen
import org.example.project.feature.about.presentation.screen.aboutScreen
import org.example.project.feature.home.presentation.navigation.HomeNavigator
import org.example.project.feature.home.presentation.screen.detail.homeDetailScreen
import org.example.project.feature.home.presentation.screen.list.homeScreen
import org.example.project.feature.login.presentation.navigation.LoginNavigator
import org.example.project.feature.login.presentation.screen.loginScreen
import org.example.project.feature.register.presentation.navigation.RegisterNavigator
import org.example.project.feature.register.presentation.screen.registerScreen
import org.example.project.feature.settings.presentation.navigation.SettingsNavigator
import org.example.project.feature.settings.presentation.screen.settingsScreen
import org.example.project.feature.splash.presentation.navigation.SplashNavigator
import org.example.project.feature.splash.presentation.screen.splashScreen
import org.example.project.feature.start.presentation.navigation.StartNavigator
import org.example.project.feature.start.presentation.screen.startScreen

@Composable
fun TourismApp() {
    val navController = rememberNavController()

    setSingletonImageLoaderFactory {
        asyncImageLoader(it)
    }

    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = Screen.Splash,
    ) {
        splashScreen(navigator = SplashNavigator(navController))
        aboutScreen()
        homeDetailScreen(navController)
        homeScreen(navigator = HomeNavigator(navController))
        startScreen(navigator = StartNavigator(navController))
        loginScreen(navigator = LoginNavigator(navController))
        registerScreen(navigator = RegisterNavigator(navController))
        settingsScreen(navigator = SettingsNavigator(navController))
    }
}
