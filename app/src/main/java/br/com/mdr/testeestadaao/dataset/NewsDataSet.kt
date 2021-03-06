package br.com.mdr.testeestadaao.dataset

import br.com.mdr.testeestadaao.api.ApiEndpoints
import br.com.mdr.testeestadaao.dataset.contracts.INewsDataSet
import br.com.mdr.testeestadaao.model.response.NewsDetailResponse
import com.google.gson.Gson

class NewsDataSet(
    private val apiEndpoints: ApiEndpoints,
    gson: Gson
): BaseDataSet(gson), INewsDataSet {

    override suspend fun getNewsDetail(newsId: String, token: String): List<NewsDetailResponse>? =
        handleResponse(apiEndpoints.getNewsDetail(newsId, token))

}