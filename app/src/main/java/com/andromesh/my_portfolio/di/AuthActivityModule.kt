package com.andromesh.my_portfolio.di

import com.andromesh.my_portfolio.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class AuthActivityModule {
    @ContributesAndroidInjector(modules = [AuthFragmentBuilderModule::class])
    abstract fun contributeMainActivity(): AuthActivity
}
