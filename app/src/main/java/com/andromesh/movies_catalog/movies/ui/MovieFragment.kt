package com.andromesh.movies_catalog.movies.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.andromesh.movies_catalog.data.Result
import com.andromesh.movies_catalog.databinding.MovieFragmentBinding
import com.andromesh.movies_catalog.di.Injectable
import com.andromesh.movies_catalog.di.injectViewModel
import com.andromesh.movies_catalog.movies.data.MovieDetail
import com.elifox.legocatalog.ui.hide
import com.elifox.legocatalog.ui.show
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class MovieFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var movieViewModel: MovieViewModel


    private lateinit var imdbId: String

    private lateinit var binding: MovieFragmentBinding


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        imdbId = arguments?.get("imdbID") as String

        movieViewModel = injectViewModel(viewModelFactory)
        movieViewModel.imDBID = imdbId


        binding = MovieFragmentBinding.inflate(inflater, container, false)
        context ?: return binding.root



        activity?.actionBar?.title = imdbId

        movieViewModel.movie.observe(viewLifecycleOwner, Observer { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    binding.progressBar.hide()
                    binding.movieDetails = result.data as MovieDetail
                }
                Result.Status.LOADING -> binding.progressBar.show()
                Result.Status.ERROR -> {
                    binding.progressBar.hide()
                    Snackbar.make(binding.root, result.message!!, Snackbar.LENGTH_LONG).show()
                }
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }

}

