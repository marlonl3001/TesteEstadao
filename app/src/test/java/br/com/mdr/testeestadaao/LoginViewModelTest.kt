package br.com.mdr.testeestadaao

import br.com.mdr.testeestadaao.extensions.observeOnce
import br.com.mdr.testeestadaao.flow.login.LoginViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.*
import org.koin.test.inject

class LoginViewModelTest: BaseUTTest() {
    private val viewModel: LoginViewModel by inject()

    @ExperimentalCoroutinesApi
    @Test
    fun `verify_login_success`() = runBlockingTest {
        viewModel.loginClick()

        viewModel.mutableToken.observeOnce {
            Assert.assertEquals(true, it.token.isNotEmpty())
        }
    }
}