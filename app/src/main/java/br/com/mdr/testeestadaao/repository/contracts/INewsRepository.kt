package br.com.mdr.testeestadaao.repository.contracts

import br.com.mdr.testeestadaao.model.response.NewsDetailResponse

interface INewsRepository {
    suspend fun getNewsDetail(newsId: String, token: String): List<NewsDetailResponse>?
}