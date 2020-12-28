package com.ahmdkhled.digissquared.Network

import retrofit2.http.GET

interface Api {

    @GET("random")
    suspend fun random()
}