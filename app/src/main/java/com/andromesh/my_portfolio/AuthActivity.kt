package com.andromesh.my_portfolio

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.andromesh.my_portfolio.databinding.LoginAuthBinding
import com.andromesh.my_portfolio.util.Constants
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject
import com.andromesh.my_portfolio.R.layout.auth_bottom_sheet

class AuthActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var navController: NavController
    private lateinit var auth: FirebaseAuth

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: LoginAuthBinding = DataBindingUtil.setContentView(this,
                R.layout.login_auth)

        auth = Firebase.auth

        navController = findNavController(R.id.nav_fragment)

        setupBottomSheet(binding.bottomSheet)

        var cgTags: ChipGroup = binding.bottomSheet.findViewById<View>(R.id.cgTags) as ChipGroup

        for (item in Constants.AUTH_TAGS) {

            val chip = Chip(cgTags.context)
            chip.text = item

            // necessary to get single selection working
            chip.isClickable = true
            chip.isCheckable = true
            cgTags.addView(chip)
        }


    }

    fun setupBottomSheet(bottomSheet: View) {
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet as ConstraintLayout?)
        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
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
        val currentUser = auth.currentUser

        if (currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector


}