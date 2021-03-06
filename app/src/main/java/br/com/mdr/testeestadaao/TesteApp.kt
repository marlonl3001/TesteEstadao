package br.com.mdr.testeestadaao

import android.app.Application
import br.com.mdr.testeestadaao.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TesteApp: Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@TesteApp)
            modules(
                listOf(
                    activityModule,
                    apiModule,
                    datasetModule,
                    networkModule,
                    preferencesModule,
                    presenterModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}