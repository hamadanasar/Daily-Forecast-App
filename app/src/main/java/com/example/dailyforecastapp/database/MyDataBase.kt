package com.example.dailyforecastapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dailyforecastapp.database.Dao.ForecastDao
import com.example.dailyforecastapp.model.WeatherResults

@Database(entities = [WeatherResults::class], version = 3, exportSchema = false)
@TypeConverters(Converter::class)
abstract class MyDataBase : RoomDatabase() {

    abstract fun forecastDao(): ForecastDao

    companion object {
        private var myDataBase: MyDataBase? = null

        fun getInstance(): MyDataBase? {
            if (myDataBase == null)
                throw  NullPointerException("database is null")
            return myDataBase
        }

        fun init(context: Context) {
            synchronized(MyDataBase::class) {
                myDataBase = Room.databaseBuilder(context, MyDataBase::class.java, "AndroideTaskDB")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
        }
    }
}