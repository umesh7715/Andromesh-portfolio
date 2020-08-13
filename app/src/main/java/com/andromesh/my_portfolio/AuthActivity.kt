package com.andromesh.my_portfolio

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.andromesh.my_portfolio.auth.ui.AuthViewModel
import com.andromesh.my_portfolio.databinding.LoginAuthBinding
import com.andromesh.my_portfolio.di.injectViewModel
import com.andromesh.my_portfolio.util.Constants
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class AuthActivity : AppCompatActivity(), HasSupportFragmentInjector {

    private lateinit var binding: LoginAuthBinding
    private lateinit var remoteConfig: FirebaseRemoteConfig

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var navController: NavController

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var authViewModel: AuthViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,
                R.layout.login_auth)

        authViewModel = injectViewModel(viewModelFactory)

        remoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 0
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)

        remoteConfig.fetchAndActivate()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val updated = task.result
                    }
                }

        navController = findNavController(R.id.nav_fragment)

        setupBottomSheet(binding.bottomSheet)

        var cgTags: ChipGroup = binding.bottomSheet.findViewById<View>(R.id.cgTags) as ChipGroup

        for (item in Constants.AUTH_TAGS) {

            val chip = Chip(cgTags.context)
            chip.text = item

            cgTags.addView(chip)
        }


    }

    fun animateThing() {


        val img_animation: ImageView = binding.bottomSheet.findViewById<View>(R.id.bsUp) as ImageView
        val display = windowManager.defaultDisplay
        val height = display.height.toFloat()
        val animation = TranslateAnimation(0f, 0f, 0f, height + 150) // new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation.duration = 1000 // animation duration
        animation.repeatCount = 5 // animation repeat count
        animation.repeatMode = 2
        img_animation.startAnimation(animation)
    }


    fun setupBottomSheet(bottomSheet: View) {
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet as ConstraintLayout)
        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

            @SuppressLint("SwitchIntDef")
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        // buttonSlideUp.text = "Slide Up"
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {

                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        //buttonSlideUp.text = "Slide Down"
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {

                    }
                    BottomSheetBehavior.STATE_SETTLING -> {

                    }
                }
            }
        })
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = authViewModel.getCurrentUser()

        if (currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    override fun onBackPressed() {

        when (navController.currentDestination?.id) {
            R.id.loginFragment -> {
                finish()
            }
            R.id.loginFragment2 -> {
                finish()
            }
            else -> {
                super.onBackPressed()
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_logout -> authViewModel.logout()
        }
        return super.onOptionsItemSelected(item)
    }


}