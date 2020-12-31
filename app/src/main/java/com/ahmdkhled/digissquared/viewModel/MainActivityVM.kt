package com.ahmdkhled.digissquared.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ahmdkhled.digissquared.model.Res
import com.ahmdkhled.digissquared.model.SignalResponse
import com.ahmdkhled.digissquared.repo.RandomNumsRepo
import kotlinx.coroutines.Dispatchers
import retrofit2.Response
import javax.inject.Inject

class MainActivityVM @Inject constructor(var randomNumbersRepo:RandomNumsRepo):ViewModel (){

    private val TAG = "MainActivityVM"

    var stop:Boolean=false
    var signals=ArrayList<SignalResponse>()

    fun getRandomNumbers() = liveData<Res<SignalResponse?>>(Dispatchers.IO) {
        emit(Res.LOADING())
        Log.d(TAG, "getRandomNumbers: ")


            val response=randomNumbersRepo.getRandomNumbers()
            if (response==null){
                emit(Res.ERROR(null,null))
                return@liveData
            }
            val signalResponse=response.body()
            if (response.isSuccessful&&signalResponse!=null){
                emit(Res.SUCCCESS(signalResponse))
                signals.add(signalResponse)
                Log.d(TAG, "getRandomNumbers: $signalResponse")
            }else{
                Log.d(TAG, "error getRandomNumbers: ")

                emit(Res.ERROR(null,"error loading signal "))

            }




    }



    }