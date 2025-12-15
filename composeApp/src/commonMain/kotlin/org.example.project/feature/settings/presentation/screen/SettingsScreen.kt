package org.example.project.feature.settings.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.example.project.core.ui.screen.Screen
import org.example.project.feature.settings.presentation.navigation.SettingsNavigator
import org.koin.compose.viewmodel.koinViewModel

fun NavGraphBuilder.settingsScreen(navigator: SettingsNavigator) {
    composable<Screen.Settings> {
        val viewModel: SettingsViewModel = koinViewModel()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        SettingsScreen(uiState, viewModel::action)
    }
}

@Composable
private fun SettingsScreen(
    uiState: SettingsUiState,
    action: (SettingsAction) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

    }
}