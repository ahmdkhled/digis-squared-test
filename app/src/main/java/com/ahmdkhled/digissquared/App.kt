package com.ahmdkhled.digissquared

import android.app.Application
import com.ahmdkhled.digissquared.dagger.*

@Suppress("DEPRECATION")
class App :Application() {

    lateinit var mainActivityComponent:MainActivityComponent
    lateinit var signalChartFragComponent:SignalChartFragComponent

    override fun onCreate() {
        super.onCreate()

        mainActivityComponent= DaggerMainActivityComponent.builder()
            .apiClientModule(ApiClientModule())
            .appModule(AppModule(this))
            .build()

        signalChartFragComponent=DaggerSignalChartFragComponent.builder()
            .build()

    }




}