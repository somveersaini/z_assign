package com.zyla.assign.di.component

import android.app.Application
import com.zyla.assign.ZApplication
import com.zyla.assign.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton
import dagger.BindsInstance
import com.zyla.assign.di.builder.ActivityBuilder





@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class])
interface AppComponent {

    fun inject(app: ZApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }


}