package org.example.project.app.di

import org.example.project.feature.home.di.homeModule
import org.example.project.feature.login.di.loginModule
import org.example.project.feature.register.di.registerModule
import org.example.project.feature.settings.di.settingsModule
import org.example.project.feature.start.di.startModule

val appModule =
    networkModule + loginModule + registerModule + homeModule + settingsModule + startModule
