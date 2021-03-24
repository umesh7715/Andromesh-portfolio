package com.andromesh.my_portfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.andromesh.my_portfolio.databinding.PlayerActivityBinding
import com.andromesh.my_portfolio.player.ui.AndrodPlayerFragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class PlayerActivity : AppCompatActivity(), HasSupportFragmentInjector {

    private lateinit var binding: PlayerActivityBinding


    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,
                R.layout.player_activity)

        AndrodPlayerFragment().apply {
            show(supportFragmentManager, AndrodPlayerFragment.TAG)
        }

    }


}