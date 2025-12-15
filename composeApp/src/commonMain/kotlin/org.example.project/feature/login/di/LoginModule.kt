package org.example.project.feature.login.di

import org.example.project.feature.login.data.repository.LoginRepository
import org.example.project.feature.login.data.source.LoginRemoteDataSource
import org.example.project.feature.login.presentation.screen.LoginViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val loginModule = module {
    viewModelOf(::LoginViewModel)
    singleOf(::LoginRepository)
    singleOf(::LoginRemoteDataSource)
}