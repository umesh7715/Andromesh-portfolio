package com.andromesh.movies_catalog.api

import com.andromesh.movies_catalog.movies.data.Movie
import retrofit2.Response
import retrofit2.http.GET

interface MoviesService {

    @GET(ENDPOINT)
    fun getMovie(imdbId: String): Response<Movie>

    companion object {
        const val ENDPOINT = "http://www.omdbapi.com/"
    }
}