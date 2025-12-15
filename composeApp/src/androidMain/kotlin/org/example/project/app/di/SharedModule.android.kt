package org.example.project.app.di

import com.chuckerteam.chucker.api.ChuckerInterceptor
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.example.project.core.util.expt.OpenBrowser
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single<HttpClientEngine> {
        OkHttp.create {
            addInterceptor(ChuckerInterceptor(androidContext()))
        }
    }

    single<OpenBrowser> {
        OpenBrowser(context = androidContext())
    }
}
