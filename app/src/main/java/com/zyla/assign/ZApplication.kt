package com.zyla.assign

import android.app.Application
import android.content.res.Configuration
import dagger.android.HasActivityInjector
import android.app.Activity
import com.zyla.assign.di.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject




class ZApplication: Application(), HasActivityInjector{

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        // Required initialization logic here!

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

    }

}