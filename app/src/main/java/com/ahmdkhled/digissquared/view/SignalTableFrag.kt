package com.ahmdkhled.digissquared.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmdkhled.digissquared.App
import com.ahmdkhled.digissquared.R
import com.ahmdkhled.digissquared.Utils.LegendParser
import com.ahmdkhled.digissquared.adapters.TableAdapter
import com.ahmdkhled.digissquared.databinding.FragSignalTableBinding
import javax.inject.Inject
import kotlin.math.sign

class SignalTableFrag :Fragment() {

    lateinit var binding:FragSignalTableBinding
    @Inject lateinit var adapter:TableAdapter
    @Inject lateinit var layoutManager:LinearLayoutManager

    private  val TAG = "SignalChartFrag"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=DataBindingUtil.inflate(inflater, R.layout.frag_signal_table,container,false)

        (requireActivity().application as App).signalTableFragComponent.inject(this)

        binding.signalsTable.adapter=adapter
        binding.signalsTable.layoutManager=layoutManager

        val signals=(activity as MainActivity).mainActivityVM.signals
        // add signals after rotaion
        adapter.addSignals(signals)
        observeSignals()


        return binding.root
    }

    fun observeSignals(){
        (activity as MainActivity).signalsOserver
            .observe(viewLifecycleOwner, Observer {res->
                Log.d(TAG, "observeSignals: $res")

                if (res!=null&&!res.loading &&res.success&&res.res!=null){
                    adapter.addSignals(res.res!!)
                    binding.signalsTable.scrollToPosition(adapter.itemCount-1)
                }
            })
    }


}