package com.ahmdkhled.digissquared.dagger

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
            .baseUrl("localhost")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}