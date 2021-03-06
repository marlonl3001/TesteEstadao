package br.com.mdr.testeestadaao.api

import br.com.mdr.testeestadaao.model.business.News
import br.com.mdr.testeestadaao.model.request.LoginRequest
import br.com.mdr.testeestadaao.model.response.LoginResponse
import br.com.mdr.testeestadaao.model.response.NewsDetailResponse
import br.com.mdr.testeestadaao.util.Constants.Companion.AUTHORIZATION
import retrofit2.Response
import retrofit2.http.*

interface ApiEndpoints {
    companion object {
        private const val LOGIN_PATH = "/login"
        private const val NEWS_PATH = "/news"
        private const val NEWS_DETAIL_PATH = "$NEWS_PATH/{id}"
    }

    @POST(LOGIN_PATH)
    suspend fun loginUser(
        @Body request: LoginRequest
    ): Response<LoginResponse>

    @GET(NEWS_PATH)
    suspend fun getNews(@Header(AUTHORIZATION) token: String): Response<List<News>>

    @GET(NEWS_DETAIL_PATH)
    suspend fun getNewsDetail(@Path("id") id: String, @Header(AUTHORIZATION) token: String):
            Response<List<NewsDetailResponse>>
}