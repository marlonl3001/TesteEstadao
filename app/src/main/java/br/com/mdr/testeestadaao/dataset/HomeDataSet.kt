package br.com.mdr.testeestadaao.dataset

import br.com.mdr.testeestadaao.api.ApiEndpoints
import br.com.mdr.testeestadaao.dataset.contracts.IHomeDataSet
import br.com.mdr.testeestadaao.model.business.News
import com.google.gson.Gson

class HomeDataSet(
    private val apiEndpoints: ApiEndpoints,
    gson: Gson
): BaseDataSet(gson), IHomeDataSet {

    override suspend fun getNews(token: String): List<News>? =
        handleResponse(apiEndpoints.getNews(token))

}