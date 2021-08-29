package com.example.dailyforecastapp.UI.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.dailyforecastapp.Error.ErrorLiveData
import com.example.dailyforecastapp.Repository.ForecastRepo
import com.example.dailyforecastapp.model.WeatherResults

class ForecastViewModel(application: Application) : AndroidViewModel(application) {

    private val forecastRepo = ForecastRepo()

    var whetherItemHandleData = ErrorLiveData<List<WeatherResults>>()

    init {
        whetherItemHandleData = forecastRepo.whetherItemHandleData
    }

    fun getDailyForecast(cityName: String) {
        forecastRepo.getDailyForecast(cityName)
    }

}