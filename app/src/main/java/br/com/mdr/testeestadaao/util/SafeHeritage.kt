package br.com.mdr.testeestadaao.util

inline fun <reified T> Any.safeHeritage(): T? =
        if (this is T) {
            this
        } else {
            null
        }

inline fun <reified T> Any.castOrNull(): T? =
        safeHeritage()

inline fun <reified T : Any> List<Any>.safeHeritage(): List<T> =
        mapNotNull {
            it.safeHeritage<T>()
        }