package br.com.mdr.testeestadaao.extensions

import br.com.mdr.testeestadaao.throwable.AppThrowable
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import retrofit2.HttpException
import java.net.UnknownHostException

typealias ErrorListener = (AppThrowable) -> Unit

fun scopeWithErrorHandling(errorListener: ErrorListener): CoroutineScope {
    val errorHandler = CoroutineExceptionHandler { _, throwable ->
        val appThrowable = when (throwable) {
            is AppThrowable -> throwable
            is HttpException -> AppThrowable.fromHttpException(throwable)
            is UnknownHostException -> AppThrowable.fromUnknownHostException()
            else -> AppThrowable.fromThrowable(throwable)
        }
        errorListener(appThrowable)
    }
    return CoroutineScope(errorHandler)
}