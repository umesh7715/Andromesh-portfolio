package com.andromesh.my_portfolio.dummy_frgaments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andromesh.my_portfolio.databinding.FragmentDummy4Binding
import com.andromesh.my_portfolio.di.Injectable
import com.google.firebase.auth.FirebaseAuth


class DummyFragmentFive : Fragment(), Injectable {

    private lateinit var binding: FragmentDummy4Binding

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDummy4Binding.inflate(inflater, container, false)
        context ?: return binding.root

        return binding.root
    }
}