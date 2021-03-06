package br.com.mdr.testeestadaao.model.business

import com.google.gson.annotations.SerializedName

data class Documento(
    val url: String,
    val source: String,
    val produto: String,
    val editoria: String,
    val subeditoria: String,
    val titulo: String,
    val credito: String,
    @SerializedName("datapub")
    val dataPub: String,
    @SerializedName("horapub")
    val horaPub: String,
    @SerializedName("linhafina")
    val linhaFina: String,
    val imagem: String,
    val thumbnail: String,
    val creditoImagem: String,
    val legendaImagem: String,
    val origem: String,
    @SerializedName("corpoformatado")
    val corpoFormatado: String
) {
    fun getDataPublicacao() = "$dataPub | $horaPub"
    fun getCreditos() = "$credito, $source"
}
