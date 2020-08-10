package com.andromesh.my_portfolio.auth.screen2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.andromesh.my_portfolio.MainActivity
import com.andromesh.my_portfolio.auth.ui.AuthViewModel
import com.andromesh.my_portfolio.databinding.LoginFragment2Binding
import com.andromesh.my_portfolio.di.Injectable
import com.andromesh.my_portfolio.di.injectViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class LoginFragment2 : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var authViewModel: AuthViewModel

    private lateinit var binding: LoginFragment2Binding

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        authViewModel = injectViewModel(viewModelFactory)

        binding = LoginFragment2Binding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.viewModel = authViewModel
        binding.lifecycleOwner = this



        binding.tvNewUSerRegister.setOnClickListener {

            val action = LoginFragment2Directions.actionLoginFragment2ToSignupFragment2()
            findNavController().navigate(action)
        }

        auth = Firebase.auth

        binding.bLogin.setOnClickListener {
            auth.signInWithEmailAndPassword(binding.etUsername.text.toString(), binding.etPassword.editText?.text.toString())
                    .addOnCompleteListener(activity as Activity) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            val user = auth.currentUser
                            startActivity(Intent(activity, MainActivity::class.java))
                            activity?.finish()
                        } else {
                            Toast.makeText(context, "Invalid crednials", Toast.LENGTH_LONG).show()
                        }
                    }
        }


        return binding.root
    }


}