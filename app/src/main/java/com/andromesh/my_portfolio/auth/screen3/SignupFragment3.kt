package com.andromesh.my_portfolio.auth.screen3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.andromesh.my_portfolio.MainActivity
import com.andromesh.my_portfolio.databinding.SignUpFragmentBinding
import com.andromesh.my_portfolio.di.Injectable
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignupFragment3 : Fragment(), Injectable {

    private lateinit var binding: SignUpFragmentBinding

    private lateinit var auth: FirebaseAuth

    val TAG = "Signup Fragment 2"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = SignUpFragmentBinding.inflate(inflater, container, false)
        context ?: return binding.root

        auth = Firebase.auth

        binding.bRegister.setOnClickListener {

            auth.createUserWithEmailAndPassword(binding.etUsername.text.toString(), binding.etPassword.text.toString())
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