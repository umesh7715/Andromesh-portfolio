package com.andromesh.my_portfolio.di


import com.andromesh.my_portfolio.dummy_frgaments.DummyFragmentFive
import com.andromesh.my_portfolio.dummy_frgaments.DummyFragmentFour
import com.andromesh.my_portfolio.dummy_frgaments.DummyFragmentThree
import com.andromesh.my_portfolio.fit.ui.AndroFITFragment
import com.andromesh.my_portfolio.movies.ui.MovieFragment
import com.andromesh.my_portfolio.movies.ui.MoviesFragment
import com.andromesh.my_portfolio.player.ui.AndroPlayerListFragment
import com.andromesh.my_portfolio.player.ui.AndrodPlayerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    //Movies
    @ContributesAndroidInjector
    abstract fun contributeMoviesFragment(): MoviesFragment

    @ContributesAndroidInjector
    abstract fun contributeMovieFragment(): MovieFragment

    //Fit
    @ContributesAndroidInjector
    abstract fun contributeDummyFragmentOne(): AndroFITFragment


    //Dummy
    @ContributesAndroidInjector
    abstract fun contributeDummyFragmentThree(): DummyFragmentThree

    @ContributesAndroidInjector
    abstract fun contributeDummyFragmentFour(): DummyFragmentFour

    @ContributesAndroidInjector
    abstract fun contributeDummyFragmentFive(): DummyFragmentFive


    //Player
    @ContributesAndroidInjector
    abstract fun contributeAndroPlayerListFragment(): AndroPlayerListFragment

    @ContributesAndroidInjector
    abstract fun contributeAndroPlayerFrgament(): AndrodPlayerFragment

}
