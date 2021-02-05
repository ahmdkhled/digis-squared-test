package com.ahmdkhled.digissquared.dagger

import com.ahmdkhled.digissquared.Utils.ChartHelper
import com.ahmdkhled.digissquared.model.SignalResponse
import com.ahmdkhled.digissquared.view.MainActivity
import dagger.Component
import org.jetbrains.annotations.NotNull
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiClientModule::class ,AppModule::class,MainActivityModule::class,ViewModelModule::class] )
interface MainActivityComponent {

    fun inject(activity : MainActivity)



}