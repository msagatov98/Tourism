package org.example.project.feature.login.data.repository

import org.example.project.core.util.result.NetworkError
import org.example.project.core.util.result.Result
import org.example.project.core.util.result.resultCatching
import org.example.project.feature.login.data.source.LoginRemoteDataSource

class LoginRepository(
    private val loginRemoteDataSource: LoginRemoteDataSource,
) {

    suspend fun login(email: String, password: String): Result<Unit, NetworkError> {
        return resultCatching { loginRemoteDataSource.login() }
    }
}