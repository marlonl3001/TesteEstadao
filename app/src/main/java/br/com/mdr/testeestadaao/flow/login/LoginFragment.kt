package br.com.mdr.testeestadaao.flow.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.mdr.testeestadaao.databinding.FragmentLoginBinding
import br.com.mdr.testeestadaao.extensions.navigateTo
import br.com.mdr.testeestadaao.extensions.showSnackMessage
import br.com.mdr.testeestadaao.flow.main.fragment.BaseFragment
import br.com.mdr.testeestadaao.util.Constants.Companion.SIGNED_TOKEN
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment: BaseFragment() {
    private var binding: FragmentLoginBinding? = null
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        binding?.viewModel = viewModel
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.mutableToken.observe(viewLifecycleOwner, {
            preferencesEditor.putString(SIGNED_TOKEN, "Bearer ${it.token}").apply()
            navigateTo(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
        })

        viewModel.errorLive.observe(viewLifecycleOwner, { apiError ->
            apiError?.error?.let {
                binding?.apply {
                    requireContext().showSnackMessage(it.erro, root)
                }
            }
        })
    }
}