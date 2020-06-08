package com.andromesh.movies_catalog.di


import com.andromesh.movies_catalog.movies.ui.MovieFragment
import com.andromesh.movies_catalog.movies.ui.MoviesFragment
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
