package com.ahmdkhled.digissquared.view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.ahmdkhled.digissquared.App
import com.ahmdkhled.digissquared.Network.Api
import com.ahmdkhled.digissquared.R
import com.ahmdkhled.digissquared.Utils.ChartHelper
import com.ahmdkhled.digissquared.databinding.ActivityMainBinding
import com.ahmdkhled.digissquared.model.Res
import com.ahmdkhled.digissquared.model.SignalResponse
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
    @Inject lateinit var signalsOserver:MutableLiveData<Res<SignalResponse?>>
    private  val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        (application as App).mainActivityComponent.inject(this)
        mainActivityVM=ViewModelProvider(this,factory).get(MainActivityVM::class.java)

        NavigationUI.setupWithNavController(binding.bottomnavigationView,Navigation.findNavController(this,R.id.nav_graph))
        mainActivityVM.stop=false

        pullFromServer()

    }

    private fun getSignalValues(){
        mainActivityVM.getRandomNumbers().observe(this, Observer {
            signalsOserver.value=it
        })
    }

    // get data from server each 2 seconds
    private fun pullFromServer(){
        lifecycleScope.launch {
            while (true){
                if (mainActivityVM.stop){
                    break
                }else{
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