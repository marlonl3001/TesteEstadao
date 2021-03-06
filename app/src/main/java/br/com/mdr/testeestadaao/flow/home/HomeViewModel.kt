package br.com.mdr.testeestadaao.flow.home

import androidx.lifecycle.MutableLiveData
import br.com.mdr.testeestadaao.flow.main.LoadingPresenter
import br.com.mdr.testeestadaao.flow.main.viewmodel.BaseViewModel
import br.com.mdr.testeestadaao.model.business.News
import br.com.mdr.testeestadaao.usecase.GetNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val getNewsUseCase: GetNewsUseCase, loadingPresenter: LoadingPresenter):
        BaseViewModel(loadingPresenter) {
    var newsList: MutableLiveData<List<News>> = MutableLiveData()

    fun fetchNewsList() {
        loadingPresenter.showLoading()
        viewModelScope.launch {
            val response = getNewsUseCase.getNews(token)

            GlobalScope.launch {
                withContext(Dispatchers.Main) {
                    loadingPresenter.hideLoading()
                    response?.let { newsList.value = it }
                }
            }
        }
    }
}