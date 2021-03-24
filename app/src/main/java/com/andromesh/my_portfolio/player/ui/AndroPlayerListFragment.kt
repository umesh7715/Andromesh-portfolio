package com.andromesh.my_portfolio.player.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andromesh.my_portfolio.R
import com.andromesh.my_portfolio.databinding.AndroPlayerListFragmentBinding
import com.andromesh.my_portfolio.di.Injectable
import com.andromesh.my_portfolio.player.data.Media
import com.elifox.legocatalog.ui.VerticalItemDecoration
import com.google.android.exoplayer2.Player

class AndroPlayerListFragment : Fragment(), Injectable, Player.EventListener {

    private lateinit var binding: AndroPlayerListFragmentBinding

    private lateinit var linearLayoutManager: LinearLayoutManager
    private val linearDecoration: RecyclerView.ItemDecoration by lazy {
        VerticalItemDecoration(
                resources.getDimension(R.dimen.margin_normal).toInt())
    }

    private val songlist = listOf(
            Media("Song 1", "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3", Media.MediaType.AUDIO),
            Media("Song 2", "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3", Media.MediaType.AUDIO),
            Media("Song 3", "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-3.mp3", Media.MediaType.AUDIO)
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = AndroPlayerListFragmentBinding.inflate(inflater, container, false)
        context ?: return binding.root

        linearLayoutManager = LinearLayoutManager(activity)
        binding.rvSongList.addItemDecoration(linearDecoration)
        binding.rvSongList.layoutManager = linearLayoutManager


        binding.rvSongList.adapter = AudioListAdapter(songlist, requireContext())

        return binding.root
    }
}