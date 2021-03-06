package br.com.mdr.testeestadaao.repository.contracts

import br.com.mdr.testeestadaao.model.request.LoginRequest
import br.com.mdr.testeestadaao.model.response.LoginResponse

interface ILoginRepository {
    suspend fun loginUser(request: LoginRequest): LoginResponse?
}