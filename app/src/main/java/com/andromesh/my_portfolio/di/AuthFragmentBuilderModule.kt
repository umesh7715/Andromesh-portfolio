package com.andromesh.my_portfolio.di

import com.andromesh.my_portfolio.auth.LoginFragment
import com.andromesh.my_portfolio.auth.SignupFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class AuthFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeSignupFragment(): SignupFragment


}