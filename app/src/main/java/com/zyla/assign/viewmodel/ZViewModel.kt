package com.zyla.assign.viewmodel

import androidx.lifecycle.*
import com.zyla.assign.data.DataRepository
import com.zyla.assign.data.SongList
import com.zyla.assign.spinner.SpinnerItem
import javax.inject.Inject
import kotlin.collections.ArrayList

class ZViewModel @Inject constructor(var dataRepository: DataRepository): ViewModel() {

    val spinnerItemArt = SpinnerItem()
    val spinnerItemNum = SpinnerItem()

    fun getSongList(): ArrayList<SongList> {
        return if (spinnerItemArt.getSelectedItemPosition() == 0) dataRepository.getArtistSongList()
        else dataRepository.getAlbumSongList()
    }

}