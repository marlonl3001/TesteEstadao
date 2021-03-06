package br.com.mdr.testeestadaao.flow.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.mdr.testeestadaao.databinding.FragmentNewsBinding
import br.com.mdr.testeestadaao.extensions.pop
import br.com.mdr.testeestadaao.flow.main.fragment.BaseFragment
import br.com.mdr.testeestadaao.util.Constants
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment: BaseFragment() {
    private var binding: FragmentNewsBinding? = null
    private val viewModel: NewsViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewsBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            viewModel.newsId = NewsFragmentArgs.fromBundle(it).newsId
        }
        setupListeners()
        setupObservers()
        getToken()
        viewModel.getNewsDetail()
    }

    private fun setupObservers() {
        viewModel.newsDetail.observe(viewLifecycleOwner, {
            binding?.documento = it
        })
    }

    private fun setupListeners() {
        binding?.apply {
            toolbar.setNavigationOnClickListener { pop() }
        }
    }

    private fun getToken() {
        preferences.getString(Constants.SIGNED_TOKEN, "")?.let {
            viewModel.token = it
        }
    }
}