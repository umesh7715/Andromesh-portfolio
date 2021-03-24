package com.andromesh.my_portfolio.player.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andromesh.my_portfolio.databinding.MediaRowItemBinding
import com.andromesh.my_portfolio.player.data.Media

class AudioListAdapter(val songList: List<Media>, val context: Context) : RecyclerView.Adapter<AudioListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MediaRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return songList.size
    }


    class ViewHolder(private val binding: MediaRowItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Media) {
            binding.apply {
                onClickListner = listener
                media = item
                executePendingBindings()
            }
        }
    }

    private fun createOnClickListener(media: Media): View.OnClickListener {
        return View.OnClickListener {


        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val media = songList.get(position)

        media?.let {
            holder.apply {
                bind(createOnClickListener(media), media)
                itemView.tag = media
            }
        }
    }

}