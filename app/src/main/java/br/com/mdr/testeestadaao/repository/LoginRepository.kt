package br.com.mdr.testeestadaao.repository

import br.com.mdr.testeestadaao.dataset.LoginDataSet
import br.com.mdr.testeestadaao.model.request.LoginRequest
import br.com.mdr.testeestadaao.model.response.LoginResponse
import br.com.mdr.testeestadaao.repository.contracts.ILoginRepository

class LoginRepository(
    private val loginDataSet: LoginDataSet
): ILoginRepository {

    override suspend fun loginUser(request: LoginRequest): LoginResponse? {
        var response: LoginResponse? = null
        loginDataSet.loginUser(request)?.let {
            response = it
        }
        return response
    }

}