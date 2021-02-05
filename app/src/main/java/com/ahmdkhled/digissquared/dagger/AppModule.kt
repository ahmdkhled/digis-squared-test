package com.ahmdkhled.digissquared.dagger

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(var application: Application) {


    @Singleton
    @Provides
    fun getAppd(): Application {
        return application
    }

    @Singleton
    @Provides
    fun getContext(): Context {
        return application.applicationContext
    }


}