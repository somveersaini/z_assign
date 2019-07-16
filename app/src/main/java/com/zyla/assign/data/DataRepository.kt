package com.zyla.assign.data

import android.app.Application
import android.util.Log
import java.io.InputStreamReader
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class DataRepository(application: Application) {

    private val rowList: ArrayList<CSVRow> = CSVDataHelper().readCSVFile(
            InputStreamReader(application.assets.open("sample_music_data.csv"))
    )

    fun getAlbumSongList(): ArrayList<SongList> {
        val map = HashMap<String, ArrayList<String>>()
        rowList.forEach {
            if (map.containsKey(it.album)) {
                map.get(it.album)?.add(it.song)
            } else {
                map.put(it.album, arrayListOf(it.song))
            }
        }
        val list = ArrayList<SongList>()
        for (entry in map.entries) {
            list.add(SongList(entry.key, entry.value))
            Log.d("databinding", " ${entry.key} ${entry.value}")
        }
        list.sortBy { it.header }
        return list
    }

    fun getArtistSongList(): ArrayList<SongList> {
        val map = HashMap<String, ArrayList<String>>()
        rowList.forEach {
            if (map.containsKey(it.artist)) {
                map.get(it.artist)?.add(it.song)
            } else {
                map.put(it.artist, arrayListOf(it.song))
            }
        }
        val list = ArrayList<SongList>()
        for (entry in map.entries) {
            list.add(SongList(entry.key, entry.value))
            Log.d("databinding", " ${entry.key} ${entry.value}")
        }
        list.sortBy { it.header }
        return list
    }

}