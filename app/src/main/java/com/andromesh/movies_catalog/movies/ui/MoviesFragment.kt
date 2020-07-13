package com.andromesh.movies_catalog.movies.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andromesh.movies_catalog.R
import com.andromesh.movies_catalog.databinding.MoviesFragmentBinding
import com.andromesh.movies_catalog.di.Injectable
import com.andromesh.movies_catalog.di.injectViewModel
import com.andromesh.movies_catalog.util.ConnectivityUtil
import com.elifox.legocatalog.ui.GridSpacingItemDecoration
import com.elifox.legocatalog.ui.VerticalItemDecoration
import com.elifox.legocatalog.ui.hide
import javax.inject.Inject

class MoviesFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var moviesViewModel: MoviesViewModel

    private lateinit var binding: MoviesFragmentBinding

    private val adapter: MoviesAdapter by lazy { MoviesAdapter() }

    private lateinit var linearLayoutManager: LinearLayoutManager
    private val linearDecoration: RecyclerView.ItemDecoration by lazy {
        VerticalItemDecoration(
                resources.getDimension(R.dimen.margin_normal).toInt())
    }

    private lateinit var gridLayoutManager: GridLayoutManager
    private val gridDecoration: RecyclerView.ItemDecoration by lazy {
        GridSpacingItemDecoration(
                SPAN_COUNT, resources.getDimension(R.dimen.margin_grid).toInt())
    }

    private var isLinearLayoutManager: Boolean = false


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        moviesViewModel = injectViewModel(viewModelFactory)

        moviesViewModel.connectivityAvailable = ConnectivityUtil.isConnected(requireContext())
        moviesViewModel.searchText = "hero"

        binding = MoviesFragmentBinding.inflate(inflater, container, false)
        context ?: return binding.root

        linearLayoutManager = LinearLayoutManager(activity)
        gridLayoutManager = GridLayoutManager(activity, SPAN_COUNT)
        setLayoutManager()

        binding.rvMovies.adapter = adapter
        subscribeUi(adapter)

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun subscribeUi(adapter: MoviesAdapter) {

        moviesViewModel.moviesList.observe(viewLifecycleOwner) {
            binding.progressBar.hide()
            adapter.submitList(it)
        }

    }

    private fun setLayoutManager() {
        val recyclerView = binding.rvMovies

        var scrollPosition = 0
        // If a layout manager has already been set, get current scroll position.
        if (recyclerView.layoutManager != null) {
            scrollPosition = (recyclerView.layoutManager as LinearLayoutManager)
                    .findFirstCompletelyVisibleItemPosition()
        }

        if (isLinearLayoutManager) {
            recyclerView.removeItemDecoration(gridDecoration)
            recyclerView.addItemDecoration(linearDecoration)
            recyclerView.layoutManager = linearLayoutManager
        } else {
            recyclerView.removeItemDecoration(linearDecoration)
            recyclerView.addItemDecoration(gridDecoration)
            recyclerView.layoutManager = gridLayoutManager
        }

        recyclerView.scrollToPosition(scrollPosition)

    }

    companion object {
        const val SPAN_COUNT = 2
    }


}