package com.ahmdkhled.digissquared.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ahmdkhled.digissquared.R
import com.ahmdkhled.digissquared.databinding.FragSignalChartBinding

class SignalTableFrag :Fragment() {

    lateinit var binding:FragSignalChartBinding
    private  val TAG = "SignalChartFrag"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=DataBindingUtil.inflate(inflater, R.layout.frag_signal_chart,container,false)
        //signalChartFragVM= ViewModelProvider(this,factory).get(SignalChartFragVM::class.java)



        return binding.root
    }


}