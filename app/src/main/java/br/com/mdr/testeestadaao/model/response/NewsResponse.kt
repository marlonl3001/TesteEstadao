package br.com.mdr.testeestadaao.model.response

import br.com.mdr.testeestadaao.model.business.News

data class NewsResponse(
    val news: List<News>
)
