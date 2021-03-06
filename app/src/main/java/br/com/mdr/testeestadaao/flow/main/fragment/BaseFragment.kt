package br.com.mdr.testeestadaao.flow.main.fragment

import android.content.SharedPreferences
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject

open class BaseFragment: Fragment() {
    val preferencesEditor: SharedPreferences.Editor by inject()
    val preferences: SharedPreferences by inject()
}