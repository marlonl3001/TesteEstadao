package br.com.mdr.testeestadaao.di

import android.content.SharedPreferences
import br.com.mdr.testeestadaao.util.Constants.Companion.AUTHORIZATION
import br.com.mdr.testeestadaao.util.Constants.Companion.BASE_URL
import br.com.mdr.testeestadaao.util.Constants.Companion.CONTENT_TYPE
import br.com.mdr.testeestadaao.util.Constants.Companion.SIGNED_TOKEN
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

val networkModule = module {

    // Retrofit
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(get())
            .client(get())
            .build()
    }

    // OkHttp Client
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get())
            //.addInterceptor(get<HeadersInterceptor>())
            .build()
    }

    // Http Logging Interceptor
    single {
        HttpLoggingInterceptor {
            Timber.d(it)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    // Interceptor
    single {
        Interceptor { chain ->
            chain.request().run {
                newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-type", "application/json")
                    .method(this.method(), this.body())
                    .build()
                    .let(chain::proceed)
            }
        }
    }

    // Gson
    single {
        GsonBuilder().create()
    }

    // GsonConverterFactory
    single {
        GsonConverterFactory.create(get()) as Converter.Factory
    }

    //HeaderInterceptor
    single {
        HeadersInterceptor(get())
    }
}

class HeadersInterceptor(
    private val preferences: SharedPreferences) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.request().run {
            newBuilder()
                    .addHeader(CONTENT_TYPE, "application/json")
                    .method(method(), body())
                    .apply {
                        val strToken = preferences.getString(SIGNED_TOKEN, "")
                        if (!strToken.isNullOrEmpty()) {
                            addHeader(AUTHORIZATION, "Bearer $strToken")
                        }
                    }
        }.run {
            chain.proceed(build())
        }
    }
}