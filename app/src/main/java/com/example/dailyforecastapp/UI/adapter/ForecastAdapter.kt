package com.example.dailyforecastapp.UI.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyforecastapp.R
import com.example.dailyforecastapp.Utils.Companion.changeTemp
import com.example.dailyforecastapp.Utils.Companion.getDate
import com.example.dailyforecastapp.Utils.Companion.getTime
import com.example.dailyforecastapp.Utils.Companion.updateWeatherIcon
import com.example.dailyforecastapp.model.WeatherResults
import kotlinx.android.synthetic.main.item_forecast.view.*

class ForecastAdapter(weathersList: List<WeatherResults>) :
    RecyclerView.Adapter<ForecastAdapter.WeatherViewHolder>() {

    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    var weathersResultsList: List<WeatherResults> = weathersList

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeatherViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val item = weathersResultsList[position]

        holder.itemView.txtTimeOfDay.text = getDate(item.dtTxt!!)
        holder.itemView.txtDayOfWeek.text = getTime(item.dtTxt!!)

        holder.itemView.imgForecastIcon.setImageResource(updateWeatherIcon(item.weatherItemList!![0].icon!!))

        holder.itemView.txtViewTemp.text = changeTemp(item.main!!.temp!!)
        holder.itemView.txtTempMin.text = changeTemp(item.main!!.tempMin!!)
        holder.itemView.txtTempMax.text = changeTemp(item.main!!.tempMax!!)
    }

    override fun getItemCount(): Int {
        return weathersResultsList.size
    }
}
