package com.example.unitconverter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputValue: EditText
    private lateinit var unitSpinner: Spinner
    private lateinit var convertButton: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputValue = findViewById(R.id.inputValue)
        unitSpinner = findViewById(R.id.unitSpinner)
        convertButton = findViewById(R.id.convertButton)
        resultText = findViewById(R.id.resultText)

        val units = arrayOf(
            "Meters to Kilometers",
            "Kilometers to Meters",
            "Grams to Kilograms",
            "Kilograms to Grams",
            "Inches to Centimeters",
            "Centimeters to Inches"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, units)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        unitSpinner.adapter = adapter

        convertButton.setOnClickListener {
            convertUnits()
        }
    }

    private fun convertUnits() {
        val input = inputValue.text.toString().toDoubleOrNull()
        if (input == null) {
            resultText.text = "Please enter a valid number."
            return
        }

        val selectedUnit = unitSpinner.selectedItem.toString()
        val result = when (selectedUnit) {
            "Meters to Kilometers" -> input / 1000
            "Kilometers to Meters" -> input * 1000
            "Grams to Kilograms" -> input / 1000
            "Kilograms to Grams" -> input * 1000
            "Inches to Centimeters" -> input * 2.54
            "Centimeters to Inches" -> input / 2.54
            else -> 0.0
        }

        resultText.text = "Result: $result"
    }
}
