package com.andromesh.my_portfolio.movies.data

import com.andromesh.my_portfolio.api.BaseDataSource
import com.andromesh.my_portfolio.api.MoviesService
import com.andromesh.my_portfolio.util.APIKeyLibrary
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(private val moviesService: MoviesService) : BaseDataSource() {

    suspend fun fetchMovies(searchText: String, page: Int) =
            getResult { moviesService.getMovies(searchText, page, API_KEY) }

    suspend fun fetchMovie(id: String) =
            getResult { moviesService.getMovie(id, API_KEY) }


    val API_KEY = APIKeyLibrary().getIMDBKey()


}