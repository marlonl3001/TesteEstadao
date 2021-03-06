package br.com.mdr.testeestadaao.usecase

import br.com.mdr.testeestadaao.model.business.News
import br.com.mdr.testeestadaao.repository.HomeRepository

class GetNewsUseCase(
    private val repository: HomeRepository
) {
    suspend fun getNews(token: String): List<News>? {
        return repository.getNews(token)
    }
}