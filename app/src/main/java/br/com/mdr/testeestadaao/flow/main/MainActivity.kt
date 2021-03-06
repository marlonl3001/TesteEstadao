package br.com.mdr.testeestadaao.flow.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.mdr.testeestadaao.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val activityPresenter: LoadingPresenter by inject()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservables()
    }

    private fun setupObservables() {
        activityPresenter.isLoading.observe(this, {
            GlobalScope.launch {
                withContext(Dispatchers.Main) { binding.showLoading = it }
            }
        })
    }
}