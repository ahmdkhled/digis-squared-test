package com.ahmdkhled.digissquared.repo

import android.util.Log
import com.ahmdkhled.digissquared.Network.Api
import com.ahmdkhled.digissquared.model.SignalResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.awaitResponse
import javax.inject.Inject
import kotlin.math.sign

class RandomNumsRepo @Inject constructor (var api :Api) {

    init {
        Log.d("MainActivityVM", "init repo: ")
    }

    suspend fun getRandomNumbers(): Response<SignalResponse>? {
        Log.d("MainActivityVM", "getRandomNumbers: ")
        try {
            return api.random()
        }catch (ex:Exception){
            Log.d("MainActivityVM", "getRandomNumbers: $ex")
            return null
        }
    }
}