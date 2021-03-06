package br.com.mdr.testeestadaao.model.business

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("id_documento")
    val id: Int,
    val chapeu: String,
    val titulo: String,
    @SerializedName("linha_fina")
    val linhaFina: String,
    @SerializedName("data_hora_publicação")
    val dataPublicacao: String,
    val url: String,
    val imagem: String,
    val source: String
)