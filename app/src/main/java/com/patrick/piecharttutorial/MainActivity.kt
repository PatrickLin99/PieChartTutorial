package com.patrick.piecharttutorial

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.patrick.piecharttutorial.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var calsBurned: Int = 0
    var calsConsumed: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


    }
    fun addBurned(v: View?) {
        // Get the new value from a user input:
//        val burnedEditText: EditText = findViewById(R.id.burned)
        val newBurnedCals = binding.burned.text.toString().toInt()

        // Update the old value:
        calsBurned = newBurnedCals
        updateChart()
    }

    fun addConsumed(v: View?) {
        // Get the new value from a user input:
//        val consumedEditText: EditText = findViewById(R.id.consumed)
        val newConsumedCals = binding.consume.text.toString().toInt()

        // Update the old value:
        calsConsumed = newConsumedCals
        updateChart()
    }

    fun updateChart() {
        // Update the text in a center of the chart:
//        val numberOfCals: TextView = findViewById(R.id.number_of_calories)
        binding.numberOfCalories.text = "$calsBurned / $calsConsumed"

        // Calculate the slice size and update the pie chart:
//        val pieChart: ProgressBar = findViewById(R.id.stats_progressbar)
        val d = calsBurned.toDouble() / calsConsumed.toDouble()
        val progress = (d * 100).toInt()
        binding.statsProgressbar.progress = progress
    }
}
