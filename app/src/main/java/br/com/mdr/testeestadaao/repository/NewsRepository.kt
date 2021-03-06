package br.com.mdr.testeestadaao.repository

import br.com.mdr.testeestadaao.dataset.NewsDataSet
import br.com.mdr.testeestadaao.model.response.NewsDetailResponse
import br.com.mdr.testeestadaao.repository.contracts.INewsRepository

class NewsRepository(
    private val dataset: NewsDataSet
): INewsRepository {

    override suspend fun getNewsDetail(newsId: String, token: String): List<NewsDetailResponse>? =
        dataset.getNewsDetail(newsId, token)
}