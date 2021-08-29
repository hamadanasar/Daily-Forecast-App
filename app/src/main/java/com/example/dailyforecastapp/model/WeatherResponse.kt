package com.example.dailyforecastapp.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class WeatherResponse(

    @field:SerializedName("city")
    var city: City? = null,

    @field:SerializedName("cnt")
    var cnt: Int? = null,

    @field:SerializedName("cod")
    var cod: String? = null,

    @field:SerializedName("message")
    var message: Int? = null,

    @field:SerializedName("list")
    var weatherResultsList: List<WeatherResults>? = null
)

data class Coord(

    @field:SerializedName("lon")
    var lon: Double? = null,

    @field:SerializedName("lat")
    var lat: Double? = null
)

data class Clouds(

    @field:SerializedName("all")
    var all: Int? = null
)

@Entity
data class WeatherItem(

    @field:SerializedName("icon")
    var icon: String? = null,

    @field:SerializedName("description")
    var description: String? = null,

    @field:SerializedName("main")
    var main: String? = null,

    @field:SerializedName("id")
    var id: Int? = null
)

data class Main(

    @field:SerializedName("temp")
    var temp: Double? = null,

    @field:SerializedName("temp_min")
    var tempMin: Double? = null,

    @field:SerializedName("grnd_level")
    var grndLevel: Int? = null,

    @field:SerializedName("temp_kf")
    var tempKf: Double? = null,

    @field:SerializedName("humidity")
    var humidity: Int? = null,

    @field:SerializedName("pressure")
    var pressure: Int? = null,

    @field:SerializedName("sea_level")
    var seaLevel: Int? = null,

    @field:SerializedName("feels_like")
    var feelsLike: Double? = null,

    @field:SerializedName("temp_max")
    var tempMax: Double? = null
)

data class Sys(

    @field:SerializedName("pod")
    var pod: String? = null
)

data class Wind(

    @field:SerializedName("deg")
    var deg: Int? = null,

    @field:SerializedName("speed")
    var speed: Double? = null,

    @field:SerializedName("gust")
    var gust: Double? = null
)

data class City(

    @field:SerializedName("country")
    var country: String? = null,

    @field:SerializedName("coord")
    var coord: Coord? = null,

    @field:SerializedName("sunrise")
    var sunrise: Int? = null,

    @field:SerializedName("timezone")
    var timezone: Int? = null,

    @field:SerializedName("sunset")
    var sunset: Int? = null,

    @field:SerializedName("name")
    var name: String? = null,

    @field:SerializedName("id")
    var id: Int? = null,

    @field:SerializedName("population")
    var population: Int? = null
)

@Entity
data class WeatherResults(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @Ignore
    @field:SerializedName("dt")
    var dt: Int? = null,

    @Ignore
    @field:SerializedName("pop")
    var pop: Int? = null,

    @Ignore
    @field:SerializedName("visibility")
    var visibility: Int? = null,

    @Ignore
    @field:SerializedName("dt_txt")
    var dtTxt: String? = null,

    @field:SerializedName("weather")
    var weatherItemList: List<WeatherItem>? = null,

    @field:SerializedName("main")
    var main: Main? = null,

    @field:SerializedName("clouds")
    var clouds: Clouds? = null,

    @Ignore
    @field:SerializedName("sys")
    var sys: Sys? = null,

    @Ignore
    @field:SerializedName("wind")
    var wind: Wind? = null
)
