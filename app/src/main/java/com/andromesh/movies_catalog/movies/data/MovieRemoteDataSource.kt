package com.andromesh.movies_catalog.movies.data

import com.andromesh.movies_catalog.api.BaseDataSource
import com.andromesh.movies_catalog.api.MoviesService
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(private val moviesService: MoviesService) : BaseDataSource() {

    suspend fun fetchMovies(page: Int, pageSize: Int? = null, themeId: Int? = null) =
            getResult { moviesService.getSets(page, pageSize, themeId, "-year") }

    suspend fun fetchMovie(id: String) =
            getResult { moviesService.getMovie(id) }

}