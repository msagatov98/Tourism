package org.example.project.core.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.path

suspend inline fun <reified T> HttpClient.get(
    path: String,
    vararg parameters: Pair<String, Any> = emptyArray(),
): T {
    return get {
        url {
            path(path)
            parameters.forEach {
                parameter(it.first, it.second)
            }
        }
    }.body<T>()
}