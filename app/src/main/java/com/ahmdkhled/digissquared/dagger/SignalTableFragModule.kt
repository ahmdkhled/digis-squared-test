package com.ahmdkhled.digissquared.dagger

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides

@Module
class SignalTableFragModule (val context:Context){

    @Provides
    fun layoutManager (): LinearLayoutManager {
        return LinearLayoutManager(context)
    }
}