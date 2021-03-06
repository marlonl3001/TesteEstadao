package br.com.mdr.testeestadaao.usecase

import br.com.mdr.testeestadaao.model.business.Documento
import br.com.mdr.testeestadaao.repository.NewsRepository

class GetNewsDetailUseCase(
    private val repository: NewsRepository
) {
    suspend fun getNewsDetail(newsId: String, token: String): Documento? {
        val response = repository.getNewsDetail(newsId, token)
        return response?.first()?.documento
    }
}