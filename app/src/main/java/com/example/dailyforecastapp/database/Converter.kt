package com.example.dailyforecastapp.database

import androidx.room.TypeConverter
import com.example.dailyforecastapp.model.Clouds
import com.example.dailyforecastapp.model.Coord
import com.example.dailyforecastapp.model.Main
import com.example.dailyforecastapp.model.WeatherItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converter {

    @TypeConverter
    fun fromArrayList(weather: List<WeatherItem>): String? {
        val gson = Gson()
        return gson.toJson(weather)
    }

    @TypeConverter
    fun fromString(string: String?): List<WeatherItem> {
        val listType: Type = object : TypeToken<WeatherItem>() {}.type
            return Gson().fromJson(string, listType)
    }

    @TypeConverter
    fun fromArrayListCoord(weather: Coord): String? {
        val gson = Gson()
        return gson.toJson(weather)
    }

    @TypeConverter
    fun fromStringCoord(string: String?): Coord {
        val listType: Type = object : TypeToken<Coord>() {}.type
        return Gson().fromJson(string, listType)
    }

    @TypeConverter
    fun fromArrayListClouds(weather: Clouds): String? {
        val gson = Gson()
        return gson.toJson(weather)
    }

    @TypeConverter
    fun fromStringClouds(string: String?): Clouds {
        val listType: Type = object : TypeToken<Clouds>() {}.type
        return Gson().fromJson(string, listType)
    }

    @TypeConverter
    fun fromArrayListMain(weather: Main): String? {
        val gson = Gson()
        return gson.toJson(weather)
    }

    @TypeConverter
    fun fromStringMain(string: String?): Main {
        val listType: Type = object : TypeToken<Main>() {}.type
        return Gson().fromJson(string, listType)
    }

}