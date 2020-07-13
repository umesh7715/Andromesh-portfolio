package com.andromesh.movies_catalog.movies.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andromesh.movies_catalog.databinding.ListItemMovieBinding
import com.andromesh.movies_catalog.movies.data.Movie

class MoviesAdapter : PagedListAdapter<Movie, MoviesAdapter.ViewHolder>(MovieDiffCallback()) {

    private lateinit var rvMovies: RecyclerView

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)

        movie?.let {
            holder.apply {
                bind(createOnClickListener(movie.imdbID), movie, isGridLayoutManager())
                itemView.tag = movie
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    private fun createOnClickListener(id: String): View.OnClickListener {
        return View.OnClickListener {
            val direction = MoviesFragmentDirections.actionMoviesFragmentToMovieFragment(id)
            it.findNavController().navigate(direction)

        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.rvMovies = recyclerView
    }

    private fun isGridLayoutManager() = rvMovies.layoutManager is GridLayoutManager


    class ViewHolder(private val binding: ListItemMovieBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Movie,
                 isGridLayoutManager: Boolean) {
            binding.apply {
                onClickListner = listener
                movie = item
                //tvName.visibility = if (isGridLayoutManager) View.GONE else View.VISIBLE
                executePendingBindings()
            }
        }
    }
}

private class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.imdbID == newItem.imdbID
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}