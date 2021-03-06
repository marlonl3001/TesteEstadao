package br.com.mdr.testeestadaao.di

import br.com.mdr.testeestadaao.api.ApiEndpoints
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(ApiEndpoints::class.java) }
}