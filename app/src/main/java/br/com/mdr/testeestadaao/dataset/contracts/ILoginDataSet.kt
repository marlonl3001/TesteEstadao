package br.com.mdr.testeestadaao.dataset.contracts

import br.com.mdr.testeestadaao.model.request.LoginRequest
import br.com.mdr.testeestadaao.model.response.LoginResponse

interface ILoginDataSet {
    suspend fun loginUser(request: LoginRequest): LoginResponse?
}