package br.com.mdr.testeestadaao.flow.error

import br.com.mdr.testeestadaao.model.business.ApiError

interface IErrorViewPresenter {
    var error: ApiError?

    fun withError(error: ApiError?): IErrorViewPresenter
}