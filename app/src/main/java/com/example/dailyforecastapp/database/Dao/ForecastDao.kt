package com.example.dailyforecastapp.database.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dailyforecastapp.model.WeatherResults

@Dao
interface ForecastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllForecasts(weatherItemList: List<WeatherResults>)

    @Query("select * from weatherResults")
    fun getAllForecasts(): List<WeatherResults>

}