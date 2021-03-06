package com.ahmdkhled.digissquared.Utils

import android.graphics.Color
import android.util.Log
import com.ahmdkhled.digissquared.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList
import kotlin.math.min

class ChartHelper @Inject constructor(){
     var dataSets=ArrayList<LineDataSet>()
    init {
        //dataset of graph one
        dataSets.add(createSet("RSRP",Color.BLUE))
        dataSets.add(createSet("RSRQ",Color.RED))
        dataSets.add(createSet("SINR",Color.GREEN))

        //dataset of graph two
        dataSets.add(createSet("RSRP",Color.BLUE))
        dataSets.add(createSet("RSRQ",Color.RED))
        dataSets.add(createSet("SINR",Color.GREEN))

        //dataset of graph three
        dataSets.add(createSet("RSRP",Color.BLUE))
        dataSets.add(createSet("RSRQ",Color.RED))
        dataSets.add(createSet("SINR",Color.GREEN))

    }

    // function for creating dataset for each graph
    private fun createSet(label:String,color:Int): LineDataSet {
        val set = LineDataSet(null, label)
        set.axisDependency = YAxis.AxisDependency.LEFT
        set.color = color
        set.setCircleColor(Color.WHITE)
        set.lineWidth = 4f
        set.circleRadius = 4f
        set.fillAlpha = 65
        set.fillColor = Color.GREEN
        set.highLightColor = Color.rgb(244, 117, 117)
        set.valueTextColor = Color.WHITE
        set.valueTextSize = 9f
        set.setDrawValues(false)
        return set
    }

    fun setupGraph(graph:LineChart,min:Float,max:Float,index: Int){

        graph.setTouchEnabled(true)
        graph.setDragEnabled(true)
        graph.setScaleEnabled(true)
        graph.setDrawGridBackground(false)
        graph.setPinchZoom(true)
        graph.setBackgroundColor(Color.parseColor("#673AB7"))
        val data = LineData()
        data.setValueTextColor(Color.WHITE)
        graph.setData(data)
        graph.getDescription().setText("time")
        graph.getDescription().setTextColor(Color.WHITE)


        val xl: XAxis = graph.getXAxis()
        xl.position=XAxis.XAxisPosition.BOTTOM_INSIDE
        xl.textColor = Color.WHITE
        xl.setDrawGridLines(false)
        xl.setAvoidFirstLastClipping(true)
        xl.isEnabled = true
        xl.valueFormatter=MyXAxisValueFormatter()

        //signal axis  |
        val leftAxis: YAxis = graph.getAxisLeft()
        leftAxis.textColor = Color.WHITE
        leftAxis.axisMaximum = max
        leftAxis.axisMinimum = min
        leftAxis.setDrawGridLines(true)
        leftAxis.gridColor = Color.WHITE

        val rightAxis: YAxis = graph.getAxisRight()
        rightAxis.isEnabled = false

        // assign datasets to each graph
        var mData=LineData(dataSets[0],dataSets[1],dataSets[2])
        if (index==1){
             mData=LineData(dataSets[3],dataSets[4],dataSets[5]);

        }else if (index==2){
             mData=LineData(dataSets[6],dataSets[7],dataSets[8]);

        }
        graph.data=mData
    }

    fun addEntry(graph: LineChart,value :Float,index:Int) {
        Log.d("TAG", "addEntry: $value $index ")
        val data=graph.data
        if (data==null)return

        var set = data.getDataSetByIndex(index)
        Log.d("TAG", "addEntry: $set \n")



        data.addEntry(
            Entry(set.entryCount.toFloat(),value ),index
        )
        data.notifyDataChanged()
        // let the graph know it's data has changed
        graph.notifyDataSetChanged()

        // limit the number of visible entries
        graph.setVisibleXRangeMaximum(10F)

        // move to the latest entry
        graph.moveViewToX(data.entryCount.toFloat())
    }

    // value formatter class for putting time on x axis
    class MyXAxisValueFormatter : ValueFormatter() {
        override fun getFormattedValue(value: Float): String {
            val hour=Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
            val minute=Calendar.getInstance().get(Calendar.MINUTE)
            return "$hour:$minute"
        }

    }
}