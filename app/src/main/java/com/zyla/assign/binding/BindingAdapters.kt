package com.zyla.assign.binding

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zyla.assign.adapter.SongsRecyclerViewAdapter
import com.zyla.assign.adapter.TopLevelRecyclerViewAdapter
import com.zyla.assign.data.SongList
import kotlin.math.min


object BindingAdapters {

    @JvmStatic
    @BindingAdapter("data", "row", "section", requireAll = true)
    fun <T> bindTopLevelRecyclerViewAdpter(recyclerView: RecyclerView, items: List<SongList>, row: Int, section: Int) {
        val topLevelRecyclerViewAdapter = TopLevelRecyclerViewAdapter(items, row)
        recyclerView.adapter = topLevelRecyclerViewAdapter
    }

    @JvmStatic
    @BindingAdapter("data", "spancount", requireAll = true)
    fun <T> bindSongRecyclerViewAdpter(recyclerView: RecyclerView, items: List<String>, spancount: Int) {
        val songsRecyclerViewAdapter = SongsRecyclerViewAdapter(items)
        val gridSpanCount = min(items.size, spancount + 1)
        recyclerView.layoutManager = GridLayoutManager(recyclerView.context, gridSpanCount, GridLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = songsRecyclerViewAdapter
    }
}
