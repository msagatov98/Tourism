package org.example.project.core.startup

import android.content.Context
import androidx.startup.Initializer
import org.example.project.app.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication

@Suppress("unused")
class KoinInitializer : Initializer<KoinApplication> {
    override fun create(context: Context): KoinApplication {
        return initKoin {
            androidContext(context)
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}