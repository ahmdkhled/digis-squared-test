package com.ahmdkhled.digissquared.Network

import com.ahmdkhled.digissquared.model.SignalResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("random")
    suspend fun random(): Response<SignalResponse>
}