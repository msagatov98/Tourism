package org.example.project.app.presentation

import androidx.compose.runtime.Composable
import org.example.project.core.ui.theme.AppTheme
import org.example.project.app.di.appModule
import org.example.project.app.di.platformModule
import org.koin.compose.KoinApplication

@Composable
fun App() {
    KoinApplication(
        application = { modules(appModule + platformModule) },
        content = { AppTheme { TourismApp() } },
    )
}
