package com.ahmdkhled.digissquared.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ahmdkhled.digissquared.R
import com.ahmdkhled.digissquared.Utils.ChartHelper
import com.ahmdkhled.digissquared.databinding.FragSignalChartBinding
import com.ahmdkhled.digissquared.model.SignalResponse
import com.ahmdkhled.digissquared.viewModel.MainActivityVM

class SignalChartFrag :Fragment() {

    lateinit var mainActivityVM: MainActivityVM
    lateinit var binding:FragSignalChartBinding
    lateinit var chartHelper: ChartHelper
    private  val TAG = "SignalChartFrag"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=DataBindingUtil.inflate(inflater, R.layout.frag_signal_chart,container,false)
        mainActivityVM=(activity as MainActivity).mainActivityVM

        chartHelper=ChartHelper()


        chartHelper.setupGraph(binding.chart1,-140f,-60f)
        chartHelper.setupGraph(binding.chart2,-30f,0f)
        chartHelper.setupGraph(binding.chart3,-10f,30f)
        //pullFromServer()


        return binding.root
    }

    private fun populateChart(signalRes: SignalResponse?) {
        if (signalRes?.RSRP!=null){
            chartHelper.addEntry(binding.chart1, signalRes.RSRP.toFloat(),0)
            chartHelper.addEntry(binding.chart2, signalRes.RSRP.toFloat(),0)
            chartHelper.addEntry(binding.chart3, signalRes.RSRP.toFloat(),0)

        }
        if (signalRes?.RSRQ!=null){
            chartHelper.addEntry(binding.chart1,signalRes.RSRQ.toFloat(),1)
            chartHelper.addEntry(binding.chart2,signalRes.RSRQ.toFloat(),1)
            chartHelper.addEntry(binding.chart3,signalRes.RSRQ.toFloat(),1)

        }
        if (signalRes?.SINR!=null){
            chartHelper.addEntry(binding.chart1,signalRes.SINR.toFloat(),2)
            chartHelper.addEntry(binding.chart2,signalRes.SINR.toFloat(),2)
            chartHelper.addEntry(binding.chart3,signalRes.SINR.toFloat(),2)

        }
    }




}