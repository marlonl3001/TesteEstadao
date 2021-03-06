package br.com.mdr.testeestadaao.dataset.contracts

import br.com.mdr.testeestadaao.model.response.NewsDetailResponse

interface INewsDataSet {
    suspend fun getNewsDetail(newsId: String, token: String): List<NewsDetailResponse>?
}