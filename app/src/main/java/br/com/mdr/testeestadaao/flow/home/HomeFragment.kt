package br.com.mdr.testeestadaao.flow.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.mdr.testeestadaao.adapter.NewsAdapter
import br.com.mdr.testeestadaao.databinding.FragmentHomeBinding
import br.com.mdr.testeestadaao.extensions.navigateTo
import br.com.mdr.testeestadaao.flow.main.fragment.BaseFragment
import br.com.mdr.testeestadaao.util.Constants.Companion.SIGNED_TOKEN

import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment: BaseFragment() {
    private var binding: FragmentHomeBinding? = null
    private val viewModel: HomeViewModel by viewModel()
    private val adapter = NewsAdapter { news ->
        navigateTo(HomeFragmentDirections.actionHomeFragmentToNewsFragment(news.id.toString()))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        binding?.recyclerNews?.adapter = adapter
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        getToken()
        viewModel.fetchNewsList()
    }

    private fun setupObservers() {
        viewModel.newsList.observe(viewLifecycleOwner, {
            adapter.replaceItens(it)
        })
    }

    private fun getToken() {
        preferences.getString(SIGNED_TOKEN, "")?.let {
            viewModel.token = it
        }
    }
}