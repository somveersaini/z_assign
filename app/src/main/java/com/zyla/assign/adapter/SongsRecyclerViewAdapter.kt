package com.zyla.assign.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zyla.assign.R
import com.zyla.assign.databinding.SongItemBinding

class SongsRecyclerViewAdapter(private val songs: List<String>) : RecyclerView.Adapter<SongsRecyclerViewAdapter.SongsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<SongItemBinding>(inflater, R.layout.song_item, parent, false)
        return SongsViewHolder(binding)
    }

    override fun getItemCount() = songs.size

    override fun onBindViewHolder(holder: SongsViewHolder, position: Int) {
        holder.bind(songs[position])
    }

    class SongsViewHolder(private val binding: SongItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(song: String) {
            binding.songName.text = song
            binding.executePendingBindings()
            Log.d("databinding", "song: $song")
        }
    }

}