package org.example.project.feature.settings.presentation.screen

import androidx.lifecycle.ViewModel
import org.example.project.core.ui.controller.DefaultScreenController
import org.example.project.core.ui.controller.ScreenController
import org.example.project.core.util.ext.empty
import org.example.project.feature.settings.data.repository.SettingsRepository
import org.example.project.feature.settings.presentation.model.TextFieldData
import tourism.composeapp.generated.resources.Res
import tourism.composeapp.generated.resources.login

class SettingsViewModel(
    private val repository: SettingsRepository,
) : ViewModel(),
    ScreenController<SettingsUiState, SettingsAction, SettingsEffect> by DefaultScreenController(
        SettingsUiState()
    ) {

    init {
        setState(
            uiState.value.copy(
                fields = listOf(
                    TextFieldData(
                        value = String.empty,
                        labelRes = Res.string.login
                    ),
                    TextFieldData(
                        value = String.empty,
                        labelRes = Res.string.login
                    ),
                    TextFieldData(
                        value = String.empty,
                        labelRes = Res.string.login
                    ),
                    TextFieldData(
                        value = String.empty,
                        labelRes = Res.string.login
                    ),
                ),
            )
        )
    }

    override fun action(action: SettingsAction) {
        when (action) {
            else -> Unit
        }
    }
}