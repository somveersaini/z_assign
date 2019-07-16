package com.zyla.assign.spinner

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.zyla.assign.BR

class SpinnerItem : BaseObservable() {
    private var selectedItemPosition = 1

    @Bindable
    fun getSelectedItemPosition() = selectedItemPosition

    fun setSelectedItemPosition(selectedItemPosition: Int) {
        this.selectedItemPosition = selectedItemPosition
        notifyPropertyChanged(BR.selectedItemPosition)
    }
}