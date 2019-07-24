package com.zyla.assign.di.module

import android.app.Application
import android.content.Context
import com.zyla.assign.data.DataRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule{

    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Context {
        return application
    }


    @Provides
    @Singleton
    fun provideDataRepository(application: Application): DataRepository {
        return DataRepository(application)
    }

}