package com.example.dailyforecastapp.Repository

import com.example.dailyforecastapp.BuildConfig
import com.example.dailyforecastapp.Error.ErrorLiveData
import com.example.dailyforecastapp.database.MyDataBase
import com.example.dailyforecastapp.model.WeatherResults
import com.example.seamlabstask.Apis.ApiManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ForecastRepo {

    private val apiManager = ApiManager().apis

    var whetherItemHandleData = ErrorLiveData<List<WeatherResults>>()

    fun getDailyForecast(cityName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiManager.getForecast(cityName, BuildConfig.Apikey)

                if (response.isSuccessful) {
                    whetherItemHandleData.postSuccess(response.body()!!.weatherResultsList!!)
                    // set In cache
                    cacheNews(response.body()!!.weatherResultsList!!)
                } else {
                    whetherItemHandleData.postFailure(response.body()!!.weatherResultsList!!)
                    // get From cache
                    getForecastsFromCache()
                }
            } catch (e: Exception) {
                whetherItemHandleData.postConnectionError()
                getForecastsFromCache()
            }
        }
    }

    private fun cacheNews(weathers: List<WeatherResults>) {
        MyDataBase.getInstance()!!.forecastDao().addAllForecasts(weathers)
    }

    private fun getForecastsFromCache() {
        val weatherItemList: List<WeatherResults> =
            MyDataBase.getInstance()!!.forecastDao().getAllForecasts()

        whetherItemHandleData.postFailure(weatherItemList)
    }

}