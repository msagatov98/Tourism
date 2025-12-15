package org.example.project.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

enum class AppTheme {
    Dark, Light, System
}

@Composable
fun AppTheme(
    theme: AppTheme = AppTheme.Light,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        content = content,
        colorScheme = when (theme) {
            AppTheme.Dark -> darkColorScheme()
            AppTheme.Light -> lightColorScheme()
            AppTheme.System -> if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
        }
    )
}