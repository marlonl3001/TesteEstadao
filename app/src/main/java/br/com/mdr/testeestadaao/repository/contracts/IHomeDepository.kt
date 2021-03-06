package br.com.mdr.testeestadaao.repository.contracts

import br.com.mdr.testeestadaao.model.business.News

interface IHomeDepository {
    suspend fun getNews(token: String): List<News>?
}