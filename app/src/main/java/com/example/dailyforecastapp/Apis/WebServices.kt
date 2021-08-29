package com.example.seamlabstask.Apis

import com.example.dailyforecastapp.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {

    @GET("forecast")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("appid") api_Key: String
    ): Response<WeatherResponse>
}