package com.andromesh.my_portfolio.api

import com.andromesh.my_portfolio.movies.data.Movie
import com.andromesh.my_portfolio.movies.data.MovieDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    @GET(ENDPOINT)
    suspend fun getMovie(@Query("i") imdbId: String, @Query("apikey") apiKey: String): Response<MovieDetail>

    @GET(ENDPOINT)
    suspend fun getMovies(@Query("s") searchArea: String,
                          @Query("page") page: Int? = null,
                          @Query("apikey") apiKey: String): Response<ResultsResponse<Movie>>

    companion object {
        const val ENDPOINT = "https://www.omdbapi.com/"
    }
}