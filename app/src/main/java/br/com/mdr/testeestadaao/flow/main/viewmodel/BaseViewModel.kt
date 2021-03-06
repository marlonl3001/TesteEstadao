package br.com.mdr.testeestadaao.flow.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.mdr.testeestadaao.flow.main.LoadingPresenter
import br.com.mdr.testeestadaao.extensions.scopeWithErrorHandling
import br.com.mdr.testeestadaao.flow.error.ErrorViewPresenter
import br.com.mdr.testeestadaao.flow.error.IErrorViewPresenter
import br.com.mdr.testeestadaao.throwable.AppThrowable
import kotlinx.coroutines.*

open class BaseViewModel(
    override val loadingPresenter: LoadingPresenter
): IViewModel, ViewModel() {
    val viewModelScope = scopeWithErrorHandling(this::showError)
    val errorLive: MutableLiveData<IErrorViewPresenter?> = MutableLiveData()
    var token: String = ""

    private fun showError(throwable: AppThrowable) {
        loadingPresenter.hideLoading()
        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                val presenter = ErrorViewPresenter().withError(throwable.error)
                errorLive.value = presenter
            }
        }
    }
}

interface IViewModel{
    val loadingPresenter: LoadingPresenter
}