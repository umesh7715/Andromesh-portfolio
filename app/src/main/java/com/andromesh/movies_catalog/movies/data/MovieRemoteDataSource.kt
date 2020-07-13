package com.andromesh.movies_catalog.movies.data

import com.andromesh.movies_catalog.BuildConfig
import com.andromesh.movies_catalog.api.BaseDataSource
import com.andromesh.movies_catalog.api.MoviesService
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(private val moviesService: MoviesService) : BaseDataSource() {

    suspend fun fetchMovies(searchText: String, page: Int) =
            getResult { moviesService.getMovies(searchText, page, API_KEY) }

    suspend fun fetchMovie(id: String) =
            getResult { moviesService.getMovie(id) }

    companion object {
        const val API_KEY = BuildConfig.API_KEY
    }

}