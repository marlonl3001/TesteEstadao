package br.com.mdr.testeestadaao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.mdr.testeestadaao.di.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest

@RunWith(JUnit4::class)
open class BaseUTTest: KoinTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        startKoin {
            modules(
                listOf(
                    apiModule,
                    datasetModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                    presenterModule,
                    activityModule
                )
            )
        }
    }

    @After
    fun removeModules() {
        stopKoin()
    }
}