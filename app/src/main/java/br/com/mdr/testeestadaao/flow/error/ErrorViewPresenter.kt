package br.com.mdr.testeestadaao.flow.error

import br.com.mdr.testeestadaao.model.business.ApiError

class ErrorViewPresenter(
    override var error: ApiError? = null
) : IErrorViewPresenter {

    override fun withError(error: ApiError?): IErrorViewPresenter {
        error?.let {
            this.error = it
        }
        return this
    }
}
