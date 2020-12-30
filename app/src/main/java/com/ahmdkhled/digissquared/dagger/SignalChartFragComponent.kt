package com.ahmdkhled.digissquared.dagger

import com.ahmdkhled.digissquared.Utils.ChartHelper
import com.ahmdkhled.digissquared.view.SignalChartFrag
import dagger.Component
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component
 interface SignalChartFragComponent {

    fun chartHelper(): ChartHelper



    fun inject(signalChartFrag: SignalChartFrag)
}