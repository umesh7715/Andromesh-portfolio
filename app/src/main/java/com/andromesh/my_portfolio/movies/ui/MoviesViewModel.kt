package com.andromesh.my_portfolio.movies.ui

import androidx.lifecycle.ViewModel
import com.andromesh.my_portfolio.di.CoroutineScropeIO
import com.andromesh.my_portfolio.movies.data.MovieRepository
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
