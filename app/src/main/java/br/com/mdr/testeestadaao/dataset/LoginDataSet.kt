package br.com.mdr.testeestadaao.dataset

import br.com.mdr.testeestadaao.api.ApiEndpoints
import br.com.mdr.testeestadaao.dataset.contracts.ILoginDataSet
import br.com.mdr.testeestadaao.model.request.LoginRequest
import br.com.mdr.testeestadaao.model.response.LoginResponse
import com.google.gson.Gson

class LoginDataSet(
    private val apiEndpoints: ApiEndpoints,
    gson: Gson
): BaseDataSet(gson), ILoginDataSet {
    override suspend fun loginUser(request: LoginRequest): LoginResponse? =
        handleResponse(apiEndpoints.loginUser(request))
}