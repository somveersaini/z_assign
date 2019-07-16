package com.zyla.assign.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zyla.assign.R
import com.zyla.assign.data.SongList
import com.zyla.assign.databinding.ArtistAlbumItemBinding

class TopLevelRecyclerViewAdapter(val topLevelData: List<SongList>, val row: Int) : RecyclerView.Adapter<TopLevelRecyclerViewAdapter.AlbumArtistViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumArtistViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ArtistAlbumItemBinding>(inflater, R.layout.artist_album_item, parent, false)
        return AlbumArtistViewHolder(binding)
    }

    override fun getItemCount() = topLevelData.size

    override fun onBindViewHolder(holder: AlbumArtistViewHolder, position: Int) {
        holder.bind(topLevelData[position], row)
    }

    class AlbumArtistViewHolder(private val binding: ArtistAlbumItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(songList: SongList, row: Int) {
            binding.songList = songList
            binding.row = row
        }
    }

}