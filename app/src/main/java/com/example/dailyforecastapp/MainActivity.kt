package com.example.dailyforecastapp

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    lateinit var progressBar: ProgressBar
    lateinit var txtNotAccurate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        txtNotAccurate = findViewById(R.id.txtNotAccurate)

        // Navigation Component
        setNavigationComponent()
    }

    private fun setNavigationComponent() {
        val navHostFrag =
            supportFragmentManager.findFragmentById(R.id.fragment_container_main) as NavHostFragment
        navController = navHostFrag.navController
        navController.setGraph(R.navigation.nav_main, intent.extras)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun showTextNotAccurate() {
        txtNotAccurate.visibility = View.VISIBLE
    }

    fun hideTextNotAccurate() {
        txtNotAccurate.visibility = View.GONE
    }

    fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

}