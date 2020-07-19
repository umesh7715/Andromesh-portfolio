package com.andromesh.my_portfolio.movies.data

import com.andromesh.my_portfolio.BuildConfig
import com.andromesh.my_portfolio.api.BaseDataSource
import com.andromesh.my_portfolio.api.MoviesService
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(private val moviesService: MoviesService) : BaseDataSource() {

    suspend fun fetchMovies(searchText: String, page: Int) =
            getResult { moviesService.getMovies(searchText, page, API_KEY) }

    suspend fun fetchMovie(id: String) =
            getResult { moviesService.getMovie(id, API_KEY) }

    companion object {
        const val API_KEY = BuildConfig.API_KEY
    }

}