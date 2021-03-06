package br.com.mdr.testeestadaao.flow.news

import androidx.lifecycle.MutableLiveData
import br.com.mdr.testeestadaao.flow.main.LoadingPresenter
import br.com.mdr.testeestadaao.flow.main.viewmodel.BaseViewModel
import br.com.mdr.testeestadaao.model.business.Documento
import br.com.mdr.testeestadaao.usecase.GetNewsDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel(private val getNewsDetailUseCase: GetNewsDetailUseCase,
                    loadingPresenter: LoadingPresenter): BaseViewModel(loadingPresenter) {
    lateinit var newsId: String
    val newsDetail: MutableLiveData<Documento> = MutableLiveData()

    fun getNewsDetail() {
        loadingPresenter.showLoading()
        viewModelScope.launch {
            val response = getNewsDetailUseCase.getNewsDetail(newsId, token)

            GlobalScope.launch {
                withContext(Dispatchers.Main) {
                    loadingPresenter.hideLoading()
                    response?.let { newsDetail.value = it }
                }
            }
        }
    }
}