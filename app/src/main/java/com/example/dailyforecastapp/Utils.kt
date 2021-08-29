package com.example.dailyforecastapp

import java.text.SimpleDateFormat
import java.util.*

class Utils {

    companion object {

        fun changeTemp(x: Double?): String {
            val celsius = x!!.toDouble() - 273.0
            val i = celsius.toInt()
            return i.toString()
        }

        fun updateWeatherIcon(condition: String): Int {
            when (condition) {
                "01d" -> {
                    return R.drawable.a01d_svg
                }
                "01n" -> {
                    return R.drawable.a01n_svg
                }
                "02d" -> {
                    return R.drawable.a02d_svg
                }
                "02n" -> {
                    return R.drawable.a02n_svg
                }
                "03d" -> {
                    return R.drawable.a03d_svg
                }
                "03n" -> {
                    return R.drawable.a03n_svg
                }
                "04d" -> {
                    return R.drawable.a04d_svg
                }
                "04n" -> {
                    return R.drawable.a04n_svg
                }
                "09d" -> {
                    return R.drawable.a09d_svg
                }
                "09n" -> {
                    return R.drawable.a09d_svg
                }
                "10d" -> {
                    return R.drawable.a10d_svg
                }
                "10n" -> {
                    return R.drawable.a10n_svg
                }
                "11d" -> {
                    return R.drawable.a11d_svg
                }
                "11n" -> {
                    return R.drawable.a11n_svg
                }
                "1232n" -> {
                    return R.drawable.a1232n_svg
                }
                "13d" -> {
                    return R.drawable.a13d_svg
                }
                "13n" -> {
                    return R.drawable.a13n_svg
                }
                "50d" -> {
                    return R.drawable.a50d_svg
                }
                "50n" -> {
                    return R.drawable.a50n_svg
                }
                else -> return R.drawable.a01d_svg
            }
        }

        // Converts to celsius
        fun convertFahrenheitToCelsius(fahrenheit: Int): Int {
            return (fahrenheit - 32) * 5 / 9
        }

        fun getDate(Date: String): String {

            val tk = StringTokenizer(Date)

            val date = tk.nextToken()
            val time = tk.nextToken()

            val sdf = SimpleDateFormat("hh:mm:ss")
            val sdfs = SimpleDateFormat("hh:mm a")

            val dt: Date = sdf.parse(time)

            return sdfs.format(dt)
        }

        fun getTime(Date: String): String {
            //startTime = "2013-02-27 21:06:30"
            val tk = StringTokenizer(Date)

            val date = tk.nextToken()
            val time = tk.nextToken()

            val dateFormat = SimpleDateFormat("yyyy-MM-dd")

            val dt2: Date = dateFormat.parse(date)

            return dateFormat.format(dt2)
        }
    }
}