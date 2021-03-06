package br.com.mdr.testeestadaao.model.business

import br.com.mdr.testeestadaao.util.ErrorType

data class ApiError (
    val erro: String
) {
    companion object {
        fun unknown() = ApiError(ErrorType.UNKNOWN.name)

        fun notFound() = ApiError(ErrorType.NOT_FOUND.name)

        fun notAuthorized() = ApiError(ErrorType.UNAUTHORIZED.name)
    }
}