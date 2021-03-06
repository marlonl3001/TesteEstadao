package br.com.mdr.testeestadaao.di

import br.com.mdr.testeestadaao.dataset.HomeDataSet
import br.com.mdr.testeestadaao.dataset.LoginDataSet
import br.com.mdr.testeestadaao.dataset.NewsDataSet
import org.koin.dsl.module

val datasetModule = module {
    single { LoginDataSet(get(), get()) }
    single { HomeDataSet(get(), get()) }
    single { NewsDataSet(get(), get()) }
}