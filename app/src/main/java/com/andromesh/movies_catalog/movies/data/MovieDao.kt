package com.andromesh.movies_catalog.movies.data

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query

@Dao
interface MovieDao {

    @Query("SELECT * FROM MOVIE ORDER BY year DESC")
    fun getPagedMovies(): DataSource.Factory<Int, Movie>

    @Query("SELECT * FROM movie_detail WHERE imdbID= :imdbID ")
    suspend fun getMovieById(imdbID: String): LiveData<Movie>
}