package org.example.project.feature.home.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Result>,
) {
    @Serializable
    data class Result(
        val name: String,
        val url: String,
    )
}

@Serializable
data class ArticlesResponse(
    val total: Int,
    val data: List<Article>
)

@Serializable
data class Article(
    val title: String,
    val preview_image: String,
)
