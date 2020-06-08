package com.andromesh.movies_catalog.movies.data

import androidx.lifecycle.distinctUntilChanged
import com.andromesh.movies_catalog.data.resultLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val movieDao: MovieDao) {

    fun observeMovie(imdbID: String) = resultLiveData(
            databaseQuery = { movieDao.getMovieById(imdbID) },
            networkCall = {},
            saveCallResult = {}
    ).distinctUntilChanged()


}