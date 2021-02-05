package com.ahmdkhled.digissquared.dagger

import com.ahmdkhled.digissquared.Network.Api
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiClientModule {


    @Singleton
    @Provides
    fun getApiClient(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("http://51.195.89.92:6000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    public fun getApiService(): Api {
        return getApiClient().create(Api::class.java)
    }


}