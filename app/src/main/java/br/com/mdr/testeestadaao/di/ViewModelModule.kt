package br.com.mdr.testeestadaao.di

import br.com.mdr.testeestadaao.flow.home.HomeViewModel
import br.com.mdr.testeestadaao.flow.login.LoginViewModel
import br.com.mdr.testeestadaao.flow.news.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get(), get()) }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { NewsViewModel(get(), get()) }
}