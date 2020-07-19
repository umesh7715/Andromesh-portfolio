package com.andromesh.my_portfolio.di


import com.andromesh.my_portfolio.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])

    abstract fun contributeMainActivity(): MainActivity

}
