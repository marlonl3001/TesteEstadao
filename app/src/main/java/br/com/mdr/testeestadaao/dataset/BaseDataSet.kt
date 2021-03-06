package br.com.mdr.testeestadaao.dataset

import br.com.mdr.testeestadaao.extensions.fromJsonOrNull
import br.com.mdr.testeestadaao.model.business.ApiError
import br.com.mdr.testeestadaao.throwable.AppThrowable
import com.google.gson.Gson
import retrofit2.Response
import timber.log.Timber

abstract class BaseDataSet(
    private val gson: Gson
) {
    protected fun <T> handleResponse(response: Response<T>): T? {
        if (response.isSuccessful) {
            return response.body()
        } else {
            val apiError = response.errorBody()?.charStream()?.let { errorJson ->
                gson.fromJsonOrNull<ApiError>(errorJson)
            }
            val errorApi = apiError ?: run {
                Timber.e( "Error object is probably malformed")
                ApiError.unknown()
            }
            throw AppThrowable(errorApi)
        }
    }
}