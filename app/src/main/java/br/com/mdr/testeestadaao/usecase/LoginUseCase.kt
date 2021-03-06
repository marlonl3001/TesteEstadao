package br.com.mdr.testeestadaao.usecase

import br.com.mdr.testeestadaao.model.request.LoginRequest
import br.com.mdr.testeestadaao.model.response.LoginResponse
import br.com.mdr.testeestadaao.repository.LoginRepository

class LoginUseCase(
    private val repository: LoginRepository
) {
    suspend fun loginUser(request: LoginRequest): LoginResponse? =
        repository.loginUser(request)
}