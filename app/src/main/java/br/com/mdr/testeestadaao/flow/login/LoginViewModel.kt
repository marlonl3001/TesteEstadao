package br.com.mdr.testeestadaao.flow.login

import androidx.lifecycle.MutableLiveData
import br.com.mdr.testeestadaao.flow.main.LoadingPresenter
import br.com.mdr.testeestadaao.flow.main.viewmodel.BaseViewModel
import br.com.mdr.testeestadaao.model.request.LoginRequest
import br.com.mdr.testeestadaao.model.response.LoginResponse
import br.com.mdr.testeestadaao.usecase.LoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(private val loginUseCase: LoginUseCase,
                     loadingPresenter: LoadingPresenter): BaseViewModel(loadingPresenter) {
    val mutableUserName: MutableLiveData<String> = MutableLiveData("devmobile")
    val mutablePassword: MutableLiveData<String> = MutableLiveData("uC&+}H4wg?rYbF:")
    val mutableToken: MutableLiveData<LoginResponse> = MutableLiveData()

    fun loginClick() {
        loadingPresenter.showLoading()
        viewModelScope.launch {
            val request = LoginRequest(
                    userName = mutableUserName.value ?: "",
                    password = mutablePassword.value ?: ""
            )
            val response = loginUseCase.loginUser(request)

            GlobalScope.launch {
                withContext(Dispatchers.Main) {
                    loadingPresenter.hideLoading()
                    response?.let { mutableToken.value = it }
                }
            }
        }
    }
}