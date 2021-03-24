package com.andromesh.my_portfolio.di

import com.andromesh.my_portfolio.player.ui.AndroPlayerListFragment
import com.andromesh.my_portfolio.player.ui.AndrodPlayerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class PlayerFragmentBuilderModue {

    //Player
    @ContributesAndroidInjector
    abstract fun contributeAndroPlayerListFragment(): AndroPlayerListFragment

    @ContributesAndroidInjector
    abstract fun contributeAndroPlayerFrgament(): AndrodPlayerFragment

}