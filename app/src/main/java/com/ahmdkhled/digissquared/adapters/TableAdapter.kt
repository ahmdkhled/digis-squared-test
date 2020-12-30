package com.ahmdkhled.digissquared.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ahmdkhled.digissquared.R
import com.ahmdkhled.digissquared.databinding.LayoutHeaderRowBinding
import com.ahmdkhled.digissquared.databinding.LayoutTableRowBinding
import com.ahmdkhled.digissquared.model.SignalResponse

class TableAdapter() :RecyclerView.Adapter<TableAdapter.TableRowViewHolder>() {

    var signals=ArrayList<SignalResponse>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableRowViewHolder {
        val binding=DataBindingUtil.inflate<LayoutTableRowBinding>(LayoutInflater.from(parent.context)
        , R.layout.layout_table_row,parent,false)
        return TableRowViewHolder(binding)

    }

    override fun onBindViewHolder(holder: TableRowViewHolder, position: Int) {
        holder.binding.signalResponse=signals[position]

    }

    override fun getItemCount(): Int {
        return signals.size
    }

    fun addSignals(signalsResopsne:SignalResponse){
        signals.add(signalsResopsne)
        notifyItemInserted(signals.size)
    }

    class TableRowViewHolder(val binding: LayoutTableRowBinding) :RecyclerView.ViewHolder(binding.root){

    }

}