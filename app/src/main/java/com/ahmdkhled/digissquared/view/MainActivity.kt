package com.ahmdkhled.digissquared.view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.ahmdkhled.digissquared.App
import com.ahmdkhled.digissquared.Network.Api
import com.ahmdkhled.digissquared.R
import com.ahmdkhled.digissquared.Utils.ChartHelper
import com.ahmdkhled.digissquared.databinding.ActivityMainBinding
import com.ahmdkhled.digissquared.viewModel.MainActivityVM
import com.ahmdkhled.digissquared.viewModel.MainActivityVMFactory
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.sign
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var mainActivityVM: MainActivityVM
    @Inject lateinit var factory:MainActivityVMFactory
    @Inject lateinit var api: Api
    lateinit var chartHelper:ChartHelper
    private  val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        (application as App).mainActivityComponent.inject(this)
        mainActivityVM=ViewModelProvider(this,factory).get(MainActivityVM::class.java)

        NavigationUI.setupWithNavController(binding.bottomnavigationView,Navigation.findNavController(this,R.id.nav_graph))





        pullFromServer()





    }

    fun getSignalValues(){
        val lifecycleOwner:LifecycleOwner=this
        mainActivityVM.getRandomNumbers()
            .observe(lifecycleOwner, Observer {res->
                Log.d(TAG, "onCreate: $res")

                if (res.success&&!res.loading){
                    val signalRes=res.res

                }

            })
    }

    fun pullFromServer(){
        lifecycleScope.launch {
            while (true){
//                getSignalValues()
                if (mainActivityVM.stop){
                    break
                }else{
                    Log.d(TAG, "repeate: ")
                    getSignalValues()
                    delay(2000)
                }

            }
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        mainActivityVM.stop=true

    }


}