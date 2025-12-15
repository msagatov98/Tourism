package org.example.project.feature.home.di

import org.example.project.feature.home.data.repository.HomeRepository
import org.example.project.feature.home.presentation.screen.list.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val homeModule = module {
    viewModelOf(::HomeViewModel)
    singleOf(::HomeRepository)
}
