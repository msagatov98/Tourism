package org.example.project.app.di

import io.ktor.client.HttpClient
import org.example.project.core.network.createHttpClient
import org.koin.dsl.module

val networkModule = module {

    single<HttpClient> {
        createHttpClient(
            baseUrl = "pokeapi.co",
            engine = get(),
        )
    }
}
