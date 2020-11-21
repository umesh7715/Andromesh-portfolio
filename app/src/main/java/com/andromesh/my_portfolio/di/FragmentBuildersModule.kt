package com.andromesh.my_portfolio.di


import com.andromesh.my_portfolio.dummy_frgaments.*
import com.andromesh.my_portfolio.fit.ui.AndroFITFragment
import com.andromesh.my_portfolio.movies.ui.MovieFragment
import com.andromesh.my_portfolio.movies.ui.MoviesFragment
import com.andromesh.my_portfolio.player.ui.AndroPlayerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMoviesFragment(): MoviesFragment

    @ContributesAndroidInjector
    abstract fun contributeMovieFragment(): MovieFragment

    @ContributesAndroidInjector
    abstract fun contributeDummyFragmentOne(): AndroFITFragment

    @ContributesAndroidInjector
    abstract fun contributeDummyFragmentTwo(): AndroPlayerFragment

    @ContributesAndroidInjector
    abstract fun contributeDummyFragmentThree(): DummyFragmentThree

    @ContributesAndroidInjector
    abstract fun contributeDummyFragmentFour(): DummyFragmentFour

    @ContributesAndroidInjector
    abstract fun contributeDummyFragmentFive(): DummyFragmentFive
}
