package com.andromesh.movies_catalog.movies.ui

import androidx.lifecycle.ViewModel
import com.andromesh.movies_catalog.di.CoroutineScropeIO
import com.andromesh.movies_catalog.movies.data.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import javax.inject.Inject

class MoviesViewModel @Inject constructor(private val movieRepository: MovieRepository,
                                          @CoroutineScropeIO private val ioCoroutineScope: CoroutineScope) : ViewModel() {


    var connectivityAvailable: Boolean = false
    lateinit var searchText: String



    val moviesList by lazy {
        movieRepository.observerPagedMovies(
                connectivityAvailable, searchText, ioCoroutineScope)
    }

    /**
     * Cancel all coroutines when the ViewModel is cleared.
     */
    override fun onCleared() {
        super.onCleared()
        ioCoroutineScope.cancel()
    }

}
