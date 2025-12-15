package org.example.project.feature.home.data.repository

import io.ktor.client.HttpClient
import org.example.project.core.network.get
import org.example.project.core.util.result.NetworkError
import org.example.project.core.util.result.Result
import org.example.project.core.util.result.map
import org.example.project.core.util.result.resultCatching
import org.example.project.feature.home.data.mapper.mapDataToPokemonList
import org.example.project.feature.home.data.model.Data
import org.example.project.feature.home.presentation.model.Pokemon

class HomeRepository(
    private val httpClient: HttpClient,
) {

    suspend fun getPokemonList(): Result<List<Pokemon>, NetworkError> {
        return resultCatching {
            httpClient.get<Data>(
                "api/v2/pokemon",
                "offset" to 1,
            )
        }.map(::mapDataToPokemonList)
    }
}