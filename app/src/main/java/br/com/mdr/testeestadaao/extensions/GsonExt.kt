package br.com.mdr.testeestadaao.extensions

import com.google.gson.Gson
import timber.log.Timber
import java.io.Reader

inline fun <reified T> Gson.fromJsonOrNull(json: Reader): T? {
    return try {
        fromJson(json, T::class.java)
    } catch (e: Throwable) {
        e.message?.let { Timber.e(it) }
        null
    }
}