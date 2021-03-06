package br.com.mdr.testeestadaao

import br.com.mdr.testeestadaao.extensions.getOrAwaitValue
import br.com.mdr.testeestadaao.flow.home.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test
import org.koin.test.inject

class HomeViewModelTest: BaseUTTest() {
    private val viewModel: HomeViewModel by inject()

    @ExperimentalCoroutinesApi
    @Test
    fun `Verify if request returns news list`() = runBlockingTest {
        viewModel.token = "Bearer jjJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.0IEYC9TrL0FfQLhfE8Sp8DnDcv2xrJLUADIM75xUSPw"
        viewModel.fetchNewsList()

        Assert.assertEquals(true, viewModel.newsList.getOrAwaitValue() != null)
    }
}