package com.ahmdkhled.digissquared.adapters

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ahmdkhled.digissquared.R
import com.ahmdkhled.digissquared.Utils.LegendParser
import com.ahmdkhled.digissquared.databinding.LayoutTableRowBinding
import com.ahmdkhled.digissquared.model.SignalResponse
import javax.inject.Inject

class TableAdapter @Inject constructor(val context: Context,val legendParser: LegendParser) :RecyclerView.Adapter<TableAdapter.TableRowViewHolder>() {

    var signals=ArrayList<SignalResponse>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableRowViewHolder {
        val binding=DataBindingUtil.inflate<LayoutTableRowBinding>(LayoutInflater.from(parent.context)
        , R.layout.layout_table_row,parent,false)
        return TableRowViewHolder(binding)

    }

    override fun onBindViewHolder(holder: TableRowViewHolder, position: Int) {
        holder.binding.signalResponse=signals[position]
        val RSRP_color=legendParser.getColor(context,signals[position].RSRP,0)
        val RSRQ_color=legendParser.getColor(context,signals[position].RSRQ,1)
        val SINR_color=legendParser.getColor(context,signals[position].SINR,2)
        holder.populateColors(RSRP_color,RSRQ_color,SINR_color)
        Log.d("TAG", "onBindViewHolder: $RSRQ_color $SINR_color" )
    }

    override fun getItemCount(): Int {
        return signals.size
    }

    fun addSignals(signalsResopsne:SignalResponse){
        signals.add(signalsResopsne)
        notifyItemInserted(signals.size)
    }

    class TableRowViewHolder(val binding: LayoutTableRowBinding) :RecyclerView.ViewHolder(binding.root){
        fun populateColors(RSRP_color: String?, RSRQ_color: String?, SINR_color: String?) {
            if (RSRP_color!=null)
            binding.RSRP.setBackgroundColor(Color.parseColor(RSRP_color))
            if (RSRQ_color!=null)
            binding.RSRQ.setBackgroundColor(Color.parseColor(RSRQ_color))
            if (SINR_color!=null)
            binding.SINR.setBackgroundColor(Color.parseColor(SINR_color))
        }
    }

}