package com.zyla.assign.di.module


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zyla.assign.di.ViewModelKey
import com.zyla.assign.viewmodel.ViewModelFactory
import com.zyla.assign.viewmodel.ZViewModel
import dagger.Binds;
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ZViewModel::class)
    abstract fun bindZViewModel(zViewModel: ZViewModel): ViewModel

    @Binds
    abstract fun bind(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}