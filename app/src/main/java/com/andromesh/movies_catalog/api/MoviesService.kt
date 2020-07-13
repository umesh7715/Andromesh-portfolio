package com.andromesh.movies_catalog.api

import com.andromesh.movies_catalog.movies.data.Movie
import com.andromesh.movies_catalog.movies.data.MovieDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    @GET(ENDPOINT)
    fun getMovie(imdbId: String): Response<MovieDetail>

    @GET(ENDPOINT)
    suspend fun getMovies(@Query("s") searchArea: String,
                          @Query("page") page: Int? = null,
                          @Query("apikey") apiKey: String): Response<ResultsResponse<Movie>>

    companion object {
        const val ENDPOINT = "https://www.omdbapi.com/"
    }
}