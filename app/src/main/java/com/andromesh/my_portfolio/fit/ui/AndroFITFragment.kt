package com.andromesh.my_portfolio.fit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andromesh.my_portfolio.databinding.AndroFitFragmentBinding
import com.andromesh.my_portfolio.di.Injectable
import com.google.firebase.auth.FirebaseAuth

class AndroFITFragment : Fragment(), Injectable {

    private lateinit var binding: AndroFitFragmentBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = AndroFitFragmentBinding.inflate(inflater, container, false)
        context ?: return binding.root

        return binding.root
    }
}