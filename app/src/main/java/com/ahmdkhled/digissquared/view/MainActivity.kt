package com.ahmdkhled.digissquared.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.ahmdkhled.digissquared.App
import com.ahmdkhled.digissquared.Network.Api
import com.ahmdkhled.digissquared.R
import com.ahmdkhled.digissquared.repo.RandomNumsRepo
import com.ahmdkhled.digissquared.viewModel.MainActivityVM
import com.ahmdkhled.digissquared.viewModel.MainActivityVMFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

     lateinit var mainActivityVM: MainActivityVM
    @Inject lateinit var factory:MainActivityVMFactory
    @Inject lateinit var api: Api
    private  val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).mainActivityComponent.inject(this)

        mainActivityVM=ViewModelProvider(this,factory).get(MainActivityVM::class.java)

        val lifecycleOwner:LifecycleOwner=this

        mainActivityVM.getRandomNumbers()
            .observe(lifecycleOwner, Observer {
                Log.d(TAG, "onCreate: $it")
            })





        
    }
}