package com.ahmdkhled.digissquared

import android.app.Application
import com.ahmdkhled.digissquared.dagger.ApiClientModule
import com.ahmdkhled.digissquared.dagger.MainActivityComponent
import com.ahmdkhled.digissquared.dagger.AppModule
import com.ahmdkhled.digissquared.dagger.DaggerMainActivityComponent

@Suppress("DEPRECATION")
class App :Application() {

    private lateinit var daggerMainActivityComponent :MainActivityComponent

    override fun onCreate() {
        super.onCreate()

        daggerMainActivityComponent= DaggerMainActivityComponent.builder()
            .apiClientModule(ApiClientModule())
            .appModule(AppModule(this))
            .build()
    }


}