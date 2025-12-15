package org.example.project.core.util.result

inline fun <T> resultCatching(block: () -> T): Result<T, NetworkError> {
    return try {
        Result.Success(data = block())
    } catch (e: Throwable) {
        Result.Failure(parseError(e))
    }
}

fun parseError(e: Throwable): NetworkError {
    return NetworkError.REQUEST_TIMEOUT
}