package org.example.project.feature.register.di

import org.example.project.feature.register.data.repository.RegisterRepository
import org.example.project.feature.register.data.source.RegisterDataSource
import org.example.project.feature.register.presentation.screen.RegisterViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val registerModule = module {
    viewModelOf(::RegisterViewModel)
    singleOf(::RegisterRepository)
    singleOf(::RegisterDataSource)
}