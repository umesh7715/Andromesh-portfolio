package com.andromesh.my_portfolio.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.andromesh.my_portfolio.databinding.PlaceholderBinding
import com.andromesh.my_portfolio.di.Injectable
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.get
import com.google.firebase.remoteconfig.ktx.remoteConfig

class PlaceholderFragment : Fragment(), Injectable {

    private lateinit var remoteConfig: FirebaseRemoteConfig
    private lateinit var binding: PlaceholderBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = PlaceholderBinding.inflate(inflater, container, false)
        context ?: return binding.root


        remoteConfig = Firebase.remoteConfig


        when (remoteConfig.get("login_screen").source) {

            1 -> findNavController().navigate(PlaceholderFragmentDirections.actionPlaceholderFragmentToLoginFragment2())
            2 -> findNavController().navigate(PlaceholderFragmentDirections.actionPlaceholderFragmentToLoginFragment2())
            3 -> findNavController().navigate(PlaceholderFragmentDirections.actionPlaceholderFragmentToLoginFragment3())
        }



        return binding.root
    }
}