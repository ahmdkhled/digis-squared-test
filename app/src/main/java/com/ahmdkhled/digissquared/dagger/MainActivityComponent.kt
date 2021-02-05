package com.ahmdkhled.digissquared.dagger

import com.ahmdkhled.digissquared.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiClientModule::class ,AppModule::class,MainActivityModule::class] )
interface MainActivityComponent {

    fun inject(activity : MainActivity)

}