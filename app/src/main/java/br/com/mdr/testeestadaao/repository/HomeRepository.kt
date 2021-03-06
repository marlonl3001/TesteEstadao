package br.com.mdr.testeestadaao.repository

import br.com.mdr.testeestadaao.dataset.HomeDataSet
import br.com.mdr.testeestadaao.model.business.News
import br.com.mdr.testeestadaao.repository.contracts.IHomeDepository

class HomeRepository(
    private val dataset: HomeDataSet
): IHomeDepository {

    override suspend fun getNews(token: String): List<News>? =
        dataset.getNews(token)
}