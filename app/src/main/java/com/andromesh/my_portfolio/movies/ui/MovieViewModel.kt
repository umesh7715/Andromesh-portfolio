package com.andromesh.my_portfolio.movies.ui

import androidx.lifecycle.ViewModel
import com.andromesh.my_portfolio.di.CoroutineScropeIO
import com.andromesh.my_portfolio.movies.data.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import javax.inject.Inject


class MovieViewModel @Inject constructor(private val repository: MovieRepository,
                                         @CoroutineScropeIO private val ioCoroutineScope: CoroutineScope)
    : ViewModel() {

    lateinit var imDBID: String

    val movie by lazy { repository.observeMovie(imDBID) }

    /**
     * Cancel all coroutines when the ViewModel is cleared.
     */
    override fun onCleared() {
        super.onCleared()
        ioCoroutineScope.cancel()
    }
}