package com.ahmdkhled.digissquared.dagger

import android.app.Application
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


}