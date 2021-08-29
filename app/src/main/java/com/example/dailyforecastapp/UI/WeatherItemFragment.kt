package com.example.dailyforecastapp.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dailyforecastapp.Error.HandleError
import com.example.dailyforecastapp.MainActivity
import com.example.dailyforecastapp.R
import com.example.dailyforecastapp.UI.adapter.ForecastAdapter
import com.example.dailyforecastapp.UI.viewmodel.ForecastViewModel
import com.example.dailyforecastapp.Utils
import com.example.dailyforecastapp.Utils.Companion.changeTemp
import com.example.dailyforecastapp.Utils.Companion.convertFahrenheitToCelsius
import com.example.dailyforecastapp.databinding.FragmentWeatherItemBinding
import com.example.dailyforecastapp.model.WeatherResults
import com.google.android.material.snackbar.Snackbar

class WeatherItemFragment : Fragment() {

    private lateinit var viewRef: FragmentWeatherItemBinding

    private val viewModel: ForecastViewModel by viewModels()

    lateinit var forecastAdapter: ForecastAdapter

    var cityName: String = ""

    var snackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        cityName = requireArguments().getString("cityName")!!

        // call api to get city name weather
        viewModel.getDailyForecast(cityName)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewRef = FragmentWeatherItemBinding.inflate(inflater, container, false)

        subscribeData()

        return viewRef.root
    }

    // set date
    private fun initView(data: List<WeatherResults>) {
        viewRef.txtCity.text = cityName

        viewRef.txtTemperature.text = changeTemp(data[0].main!!.temp) + "°"

        viewRef.txtWeatherMain.text = data[0].weatherItemList!![0].description
        viewRef.txtHumidityHeader.text = data[0].weatherItemList!![0].main

        viewRef.txtHumidity.text =
            convertFahrenheitToCelsius(data[0].main!!.humidity!!).toString() + "°"

        viewRef.imgWeatherIcon.setImageResource(Utils.updateWeatherIcon(data[0].weatherItemList!![0].icon!!))
    }

    private fun subscribeData() {
        viewModel.whetherItemHandleData.observe(viewLifecycleOwner, {
            when (it.getStatus()) {
                HandleError.DataStatus.SUCCESS -> {
                    (requireActivity() as MainActivity?)!!.hideProgressBar()
                    (requireActivity() as MainActivity?)!!.hideTextNotAccurate()
                    initView(it.getData()!!)
                    initRecycler(it.getData()!!)
                }
                HandleError.DataStatus.FAILURE -> {
                    if (it.getData() != null) {
                        (requireActivity() as MainActivity?)!!.hideProgressBar()
                        (requireActivity() as MainActivity?)!!.showTextNotAccurate()
                        initView(it.getData()!!)
                        initRecycler(it.getData()!!)
                    } else {
                        (requireActivity() as MainActivity?)!!.hideProgressBar()
                        showSnackBar(requireView(), "Sorry Error", "Retry") {
                            (requireActivity() as MainActivity?)!!.showProgressBar()
                            viewModel.getDailyForecast(cityName)
                        }
                    }
                }
                HandleError.DataStatus.CONNECTIONERROR -> {
                    (requireActivity() as MainActivity?)!!.hideProgressBar()
                    (requireActivity() as MainActivity?)!!.showTextNotAccurate()
                }
            }
        })
    }

    private fun showSnackBar(
        view: View, message: String, posActionName: String,
        onClickListener: View.OnClickListener
    ) {
        snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            .setAction(posActionName, onClickListener)
            .setActionTextColor(ContextCompat.getColor(requireContext(), R.color.colorYellow))
        snackbar!!.show()
    }

    // set Recycler
    private fun initRecycler(data: List<WeatherResults>) {
        viewRef.recyclerForecast.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            forecastAdapter = ForecastAdapter(data)
            adapter = forecastAdapter
        }
    }

}