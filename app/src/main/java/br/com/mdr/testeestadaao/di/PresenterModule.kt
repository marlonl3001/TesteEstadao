package br.com.mdr.testeestadaao.di

import br.com.mdr.testeestadaao.flow.error.ErrorViewPresenter
import org.koin.dsl.module

val presenterModule = module {
    // Error
    single { ErrorViewPresenter() }
}