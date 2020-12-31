package com.ahmdkhled.digissquared.Utils

import android.content.Context
import android.util.Log
import com.ahmdkhled.digissquared.model.Legend
import com.ahmdkhled.digissquared.model.RangeColor
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LegendParser @Inject constructor(){


    companion object {
        var legend:Legend?=null
        // extract legend data from legend.json file
        fun getJsonFromAssets(context: Context): Legend? {

            try {

                val inputStream: InputStream = context.getAssets().open("Legend.json")
                val size: Int = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                val jsonString = String(buffer, Charsets.UTF_8)
                val gson = Gson()
                val legend = gson.fromJson(jsonString, Legend::class.java)
                Log.d("parse", "getJsonFromAssets: $jsonString")
                Log.d("parse", "getJsonFromAssets: $legend")
                return legend

            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("TAG", "getJsonFromAssets: ${e.message}")
                return null
            }

        }
    }
    // get color based on legend instructions
    fun getColor(context: Context,value:Double,type:Int):String?{
        if (legend==null)
        legend=getJsonFromAssets(context)

        if (legend==null) return null

        var ranges= legend!!.RSRP
        if (type==1) ranges= legend!!.RSRQ
        if (type==2)ranges= legend!!.SINR

        for (rangeColor in ranges){
            var from:Double
            var to:Double
            if (rangeColor.From.equals("Min"))
                from=Double.NEGATIVE_INFINITY
            else
                from=rangeColor.From.toDouble()
            if (rangeColor.To.equals("Max"))
                to=Double.POSITIVE_INFINITY
            else
                to=rangeColor.To.toDouble()

            if (value in from..to){
                return rangeColor.Color
            }

        }
        return null


    }


}