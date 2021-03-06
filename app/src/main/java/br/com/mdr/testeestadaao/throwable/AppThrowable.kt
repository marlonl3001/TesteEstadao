package br.com.mdr.testeestadaao.throwable

import br.com.mdr.testeestadaao.model.business.ApiError
import retrofit2.HttpException

class AppThrowable(
    val error: ApiError
) : Throwable() {

    companion object {

        fun fromHttpException(httpException: HttpException): AppThrowable {
            return when (httpException.code()) {
                401 -> AppThrowable(unauthorizedError())
                404 -> AppThrowable(notFoundError())
                else -> AppThrowable(unknownError())
            }
        }

        fun fromUnknownHostException(): AppThrowable = AppThrowable(notFoundError())

        fun fromThrowable(t: Throwable) = AppThrowable(ApiError(t.message ?: ""))

        private fun notFoundError() = ApiError.notFound()

        private fun unknownError() = ApiError.unknown()

        private fun unauthorizedError() = ApiError.notAuthorized()
    }
}