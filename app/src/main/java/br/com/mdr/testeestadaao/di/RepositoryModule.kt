package br.com.mdr.testeestadaao.di

import br.com.mdr.testeestadaao.repository.HomeRepository
import br.com.mdr.testeestadaao.repository.LoginRepository
import br.com.mdr.testeestadaao.repository.NewsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { LoginRepository(get()) }
    single { HomeRepository(get()) }
    single { NewsRepository(get()) }
}