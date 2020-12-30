package com.ahmdkhled.digissquared

import android.app.Application
import com.ahmdkhled.digissquared.dagger.*

@Suppress("DEPRECATION")
class App :Application() {

    lateinit var mainActivityComponent:MainActivityComponent
    lateinit var signalChartFragComponent:SignalChartFragComponent
    lateinit var signalTableFragComponent:SignalTableFragmentComponent

    override fun onCreate() {
        super.onCreate()

        mainActivityComponent= DaggerMainActivityComponent.builder()
            .apiClientModule(ApiClientModule())
            .appModule(AppModule(this))
            .build()

        signalChartFragComponent=DaggerSignalChartFragComponent.builder()
            .build()

        signalTableFragComponent=DaggerSignalTableFragmentComponent
                .builder()
                .appModule(AppModule(this))
                .build()

    }




}