package com.andromesh.my_portfolio.di

import com.andromesh.my_portfolio.PlayerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class PlayerActivityModule {
    @ContributesAndroidInjector(modules = [PlayerFragmentBuilderModue::class])
    abstract fun contributeMainActivity(): PlayerActivity
}
