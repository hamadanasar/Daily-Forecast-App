package com.example.dailyforecastapp

import android.app.Application
import com.example.dailyforecastapp.database.MyDataBase

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize Database
        MyDataBase.init(this)
    }

}