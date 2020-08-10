package com.andromesh.my_portfolio.di

import com.andromesh.my_portfolio.auth.PlaceholderFragment
import com.andromesh.my_portfolio.auth.screen1.LoginFragment
import com.andromesh.my_portfolio.auth.screen1.SignupFragment
import com.andromesh.my_portfolio.auth.screen2.LoginFragment2
import com.andromesh.my_portfolio.auth.screen2.SignupFragment2
import com.andromesh.my_portfolio.auth.screen3.LoginFragment3
import com.andromesh.my_portfolio.auth.screen3.SignupFragment3
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class AuthFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributePlaceholderFragment(): PlaceholderFragment


    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment2(): LoginFragment2

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment3(): LoginFragment3

    @ContributesAndroidInjector
    abstract fun contributeSignupFragment(): SignupFragment

    @ContributesAndroidInjector
    abstract fun contributeSignupFragment2(): SignupFragment2

    @ContributesAndroidInjector
    abstract fun contributeSignupFragment3(): SignupFragment3


}