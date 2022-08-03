package com.andromesh.my_portfolio.auth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.andromesh.my_portfolio.MainActivity
import com.andromesh.my_portfolio.databinding.LoginFragmentBinding
import com.andromesh.my_portfolio.di.Injectable
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment(), Injectable {

    private lateinit var binding: LoginFragmentBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.tvNewUSerRegister.setOnClickListener {

            val action = LoginFragmentDirections.actionLoginFragmentToSignupFragment();
            findNavController().navigate(action)
        }

        auth = Firebase.auth

        binding.bLogin.setOnClickListener {
            auth.signInWithEmailAndPassword(
                binding.etUsername.text.toString(),
                binding.etPassword.text.toString()
            )
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