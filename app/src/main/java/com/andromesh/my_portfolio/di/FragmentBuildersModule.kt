package com.andromesh.my_portfolio.di


import com.andromesh.my_portfolio.movies.ui.MovieFragment
import com.andromesh.my_portfolio.movies.ui.MoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMoviesFragment(): MoviesFragment

    @ContributesAndroidInjector
    abstract fun contributeMovieFragment(): MovieFragment


}
