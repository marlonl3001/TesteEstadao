package br.com.mdr.testeestadaao.dataset.contracts

import br.com.mdr.testeestadaao.model.business.News

interface IHomeDataSet {
    suspend fun getNews(token: String): List<News>?
}