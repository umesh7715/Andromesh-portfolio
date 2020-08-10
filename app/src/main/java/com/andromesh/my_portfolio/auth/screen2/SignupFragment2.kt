package com.andromesh.my_portfolio.auth.screen2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.andromesh.my_portfolio.MainActivity
import com.andromesh.my_portfolio.auth.ui.AuthViewModel
import com.andromesh.my_portfolio.databinding.SignupFragment2Binding
import com.andromesh.my_portfolio.di.Injectable
import com.andromesh.my_portfolio.di.injectViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class SignupFragment2 : Fragment(), Injectable {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var authViewModel: AuthViewModel
    private lateinit var binding: SignupFragment2Binding

    private lateinit var auth: FirebaseAuth

    val TAG = "Signup Fragment 2"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = SignupFragment2Binding.inflate(inflater, container, false)
        context ?: return binding.root

        auth = Firebase.auth

        authViewModel = injectViewModel(viewModelFactory)

        binding.viewModel = authViewModel
        binding.lifecycleOwner = this

        binding.bRegister.setOnClickListener {

            auth.createUserWithEmailAndPassword(binding.etUsername.editText?.text.toString(), binding.etPassword.editText?.text.toString())
                    .addOnCompleteListener(activity as Activity) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(activity, "New user created", Toast.LENGTH_SHORT).show()
                            val user = auth.currentUser
                            startActivity(Intent(activity, MainActivity::class.java))
                            activity?.finish()

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(activity, "Authentication failed.", Toast.LENGTH_SHORT).show()
                        }

                    }
        }

        return binding.root
    }

}