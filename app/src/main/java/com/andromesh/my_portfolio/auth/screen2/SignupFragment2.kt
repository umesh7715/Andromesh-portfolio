package com.andromesh.my_portfolio.auth.screen2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.andromesh.my_portfolio.MainActivity
import com.andromesh.my_portfolio.auth.ui.AuthViewModel
import com.andromesh.my_portfolio.data.Result
import com.andromesh.my_portfolio.databinding.SignupFragment2Binding
import com.andromesh.my_portfolio.di.Injectable
import com.andromesh.my_portfolio.di.injectViewModel
import com.elifox.legocatalog.ui.hide
import com.elifox.legocatalog.ui.show
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class SignupFragment2 : Fragment(), Injectable {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var authViewModel: AuthViewModel
    private lateinit var binding: SignupFragment2Binding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = SignupFragment2Binding.inflate(inflater, container, false)
        context ?: return binding.root

        authViewModel = injectViewModel(viewModelFactory)

        binding.viewModel = authViewModel
        binding.lifecycleOwner = this

        binding.bRegister.setOnClickListener {

            if (authViewModel.emailAddress.value.toString().isEmpty()
                    && authViewModel.password.value.toString().isEmpty()
                    && authViewModel.confirmPassword.value.toString().isEmpty()) {
                Snackbar.make(binding.root, "Please enter email id and password", Snackbar.LENGTH_LONG).show()
            } else {
                authViewModel.signUp(authViewModel.emailAddress.value.toString(), binding.etPassword.editText?.text.toString())
                authViewModel.user.observe(viewLifecycleOwner, Observer { result ->

                    when (result.status) {
                        Result.Status.SUCCESS -> {
                            binding.progressBar3.hide()
                            startActivity(Intent(activity, MainActivity::class.java))
                            activity?.finish()

                        }
                        Result.Status.LOADING -> binding.progressBar3.show()
                        Result.Status.ERROR -> {
                            binding.progressBar3.hide()
                            Snackbar.make(binding.root, result.message!!, Snackbar.LENGTH_LONG).show()
                        }
                    }


                })
            }


        }

        return binding.root
    }

}