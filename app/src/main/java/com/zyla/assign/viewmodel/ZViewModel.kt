package com.zyla.assign.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.zyla.assign.data.DataRepository
import com.zyla.assign.data.SongList
import com.zyla.assign.spinner.SpinnerItem
import kotlin.collections.ArrayList

class ZViewModel(app: Application) : AndroidViewModel(app) {

    val spinnerItemArt = SpinnerItem()
    val spinnerItemNum = SpinnerItem()
    private val dataRepository = DataRepository(getApplication())

    fun getSongList(): ArrayList<SongList> {
        return if (spinnerItemArt.getSelectedItemPosition() == 0) dataRepository.getArtistSongList()
        else dataRepository.getAlbumSongList()
    }

}