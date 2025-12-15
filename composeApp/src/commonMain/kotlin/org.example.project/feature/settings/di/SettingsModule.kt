package org.example.project.feature.settings.di

import org.example.project.feature.settings.data.repository.SettingsRepository
import org.example.project.feature.settings.presentation.screen.SettingsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val settingsModule = module {
    viewModelOf(::SettingsViewModel)
    singleOf(::SettingsRepository)
}