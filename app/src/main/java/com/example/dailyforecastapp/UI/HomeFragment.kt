package com.example.dailyforecastapp.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dailyforecastapp.MainActivity
import com.example.dailyforecastapp.R
import com.example.dailyforecastapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewRef: FragmentHomeBinding

    private var cityName: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        homeViewRef = FragmentHomeBinding.inflate(inflater, container, false)

        btnListener()

        return homeViewRef.root
    }

    private fun btnListener() {
        homeViewRef.imgNext.setOnClickListener {
            cityName = homeViewRef.edtEnterCity.text.toString()
            if (validate()) {
                (requireActivity() as MainActivity?)!!.showProgressBar()
                val bundle = Bundle()
                bundle.putString("cityName", cityName)
                findNavController().navigate(
                    R.id.action_homeFragment_to_weatherItemFragment,
                    bundle
                )
            }
        }
    }

    private fun validate(): Boolean {
        return if (cityName.isEmpty()) {
            homeViewRef.edtEnterCity.error = getString(R.string.required_field)
            Toast.makeText(requireContext(), getString(R.string.please_enter_city_name), Toast.LENGTH_SHORT).show()
            false
        } else true
    }

}