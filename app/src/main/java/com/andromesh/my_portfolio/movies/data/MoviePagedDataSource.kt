package com.andromesh.my_portfolio.movies.data

import androidx.paging.PageKeyedDataSource
import com.andromesh.my_portfolio.data.Result
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class MoviePagedDataSource @Inject constructor(
        private val searchText: String,
        private val dataSource: MovieRemoteDataSource,
        private val dao: MovieDao,
        private val scope: CoroutineScope) : PageKeyedDataSource<Int, Movie>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Movie>) {
        fetchData(1, params.requestedLoadSize) {
            callback.onResult(it, null, 2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        val page = params.key
        fetchData(page, params.requestedLoadSize) {
            callback.onResult(it, page + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        val page = params.key
        fetchData(page, params.requestedLoadSize) {
            callback.onResult(it, page - 1)
        }
    }

    private fun fetchData(page: Int, pageSize: Int, callback: (List<Movie>) -> Unit) {
        scope.launch(getJobErrorHandler()) {
            val response = dataSource.fetchMovies(searchText, page)
            if (response.status == Result.Status.SUCCESS) {
                val results = response.data!!.search
                dao.insertAll(results)
                callback(results)
            } else if (response.status == Result.Status.ERROR) {
                postError(response.message!!)
            }
        }
    }

    private fun getJobErrorHandler() = CoroutineExceptionHandler { _, e ->
        postError(e.message ?: e.toString())
    }

    private fun postError(message: String) {
        Timber.e("An error happened: $message")
        // TODO network error handling
        //networkState.postValue(NetworkState.FAILED)
    }

}