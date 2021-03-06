package br.com.mdr.testeestadaao.di

import br.com.mdr.testeestadaao.flow.main.LoadingPresenter
import org.koin.dsl.module

val activityModule = module {
    single { LoadingPresenter() }
}