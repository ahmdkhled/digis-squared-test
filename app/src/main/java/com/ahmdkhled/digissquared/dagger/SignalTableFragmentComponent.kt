package com.ahmdkhled.digissquared.dagger

import com.ahmdkhled.digissquared.Utils.LegendParser
import com.ahmdkhled.digissquared.adapters.TableAdapter
import com.ahmdkhled.digissquared.view.SignalTableFrag
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface SignalTableFragmentComponent {

    fun inject(signalTableFrag: SignalTableFrag)

    fun legendParser():LegendParser

    fun tableAdapter(): TableAdapter
}