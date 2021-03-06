package br.com.mdr.testeestadaao.di

import br.com.mdr.testeestadaao.usecase.GetNewsDetailUseCase
import br.com.mdr.testeestadaao.usecase.GetNewsUseCase
import br.com.mdr.testeestadaao.usecase.LoginUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { LoginUseCase(get()) }
    single { GetNewsUseCase(get()) }
    single { GetNewsDetailUseCase(get()) }
}