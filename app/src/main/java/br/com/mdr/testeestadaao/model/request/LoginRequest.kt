package br.com.mdr.testeestadaao.model.request

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("user")
    val userName: String,
    @SerializedName("pass")
    val password: String
)