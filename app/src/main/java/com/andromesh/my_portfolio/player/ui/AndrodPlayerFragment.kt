package com.andromesh.my_portfolio.player.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.andromesh.my_portfolio.databinding.AndroPlayerFragmentBinding
import com.andromesh.my_portfolio.di.Injectable
import com.google.android.exoplayer2.Player
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AndrodPlayerFragment : BottomSheetDialogFragment(), Injectable, Player.EventListener {

    private lateinit var binding: AndroPlayerFragmentBinding
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = AndroPlayerFragmentBinding.inflate(inflater, container, false)
        context ?: return binding.root

        bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheet)

        bottomSheetBehavior.addBottomSheetCallback(object :
                BottomSheetBehavior.BottomSheetCallback() {

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // handle onSlide
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> Toast.makeText(context, "STATE_COLLAPSED", Toast.LENGTH_SHORT).show()
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        /*showView(binding.appBarLayout, getActionBarSize())
                        hideAppBar(bindingx.profileLayout)*/
                    }
                    BottomSheetBehavior.STATE_DRAGGING
                    -> Toast.makeText(context, "STATE_DRAGGING", Toast.LENGTH_SHORT).show()
                    BottomSheetBehavior.STATE_SETTLING -> Toast.makeText(context, "STATE_SETTLING", Toast.LENGTH_SHORT).show()
                    BottomSheetBehavior.STATE_HIDDEN -> Toast.makeText(context, "STATE_HIDDEN", Toast.LENGTH_SHORT).show()
                    else -> Toast.makeText(context, "OTHER_STATE", Toast.LENGTH_SHORT).show()
                }
            }
        })



        return binding.root
    }

    private fun hideAppBar(view: View) {
        val params = view.layoutParams
        params.height = 0
        view.layoutParams = params
    }

    private fun showView(view: View, size: Int) {
        val params = view.layoutParams
        params.height = size
        view.layoutParams = params
    }

    companion object {

        const val TAG = "AndrodPlayerFragment"

    }

}
