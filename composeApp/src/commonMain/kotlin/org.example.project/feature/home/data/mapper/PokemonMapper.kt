package org.example.project.feature.home.data.mapper

import org.example.project.feature.home.data.model.ArticlesResponse
import org.example.project.feature.home.data.model.Data
import org.example.project.feature.home.presentation.model.Pokemon

fun mapDataToPokemonList(data: Data): List<Pokemon> {
    return data.results.map {
        val number = if (it.url.endsWith("/")) {
            it.url.dropLast(1).takeLastWhile { it.isDigit() }
        } else {
            it.url.takeLastWhile { it.isDigit() }
        }
        val url =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"

        Pokemon(
            name = it.name,
            imageUrl = url,
        )
    }
}


fun mapDataToArticlesList(data: ArticlesResponse): List<Pokemon> {
    return data.data.map {

        Pokemon(
            name = it.title,
            imageUrl = "https://api.respublica-partiyasy.kz/" + it.preview_image,
        )
    }
}
