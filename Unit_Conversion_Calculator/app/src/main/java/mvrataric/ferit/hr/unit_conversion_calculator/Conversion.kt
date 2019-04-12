package mvrataric.ferit.hr.unit_conversion_calculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_conversion.*

class Conversion : AppCompatActivity() {

    companion object {
        const val INPUT_VALUE_KEY = "1"
        const val RESULT_VALUE_KEY = "2"
        const val SPINNER_KEY = "3"
        const val SPINNER_CONVERTED_KEY = "4"
     }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversion)
        setUpUi()
    }

    private fun setUpUi() {
        startIntent()
        btnConverAction.setOnClickListener { onClickAction() }
    }

    //put description to TextView
    private fun startIntent() {
        val getDescriptionName = intent.getStringExtra("KEY_EXTRA")
        tvConversionTitle.text = getDescriptionName
        if(tvConversionTitle.text == "Temperature"){
            spinnFromTemperature()
            spinToTemperature()
        }else if(tvConversionTitle.text == "Distance"){
            spinnFromDistance()
            spinnToDistance()
        }else if(tvConversionTitle.text == "Weight"){
            spinnFromWeight()
            spinnToWeight()
        }else {
            spinnFromDigital()
            spinnToDigital()
        }
    }

    private fun onClickAction() {
        val myIntent = Intent(this, Result::class.java)

        //saving entered values from EditText and Spinner
        val enteredValue = etEnterItemValue.text.toString()
        val enteredSpinner= spinnerConversionFrom.selectedItem.toString()
        val resultSpinner = spinnerConversionTo.selectedItem.toString()

        //selected spinner action
        if(spinnerConversionFrom.selectedItem.toString() == "Celsius"){
            val result = CelsiusToKelvin(enteredValue.toFloat())
            val resultValueConverted = result.toString()
            myIntent.putExtra(RESULT_VALUE_KEY,resultValueConverted)
        }
        else if(spinnerConversionFrom.selectedItem.toString() == "Kelvin"){
            val result = KelvinToCelsius(enteredValue.toFloat())
            val resultValueConverted = result.toString()
            myIntent.putExtra(RESULT_VALUE_KEY,resultValueConverted)
        }
        else if(spinnerConversionFrom.selectedItem.toString() == "Meter"){
            val result = convertFrom(enteredValue.toDouble(),100.00)
            val resultValueConverted = result.toString()
            myIntent.putExtra(RESULT_VALUE_KEY,resultValueConverted)
        }
        else if(spinnerConversionFrom.selectedItem.toString() == "Centimeter"){
            val result = convertTo(enteredValue.toDouble(), 100.00)
            val resultValueConverted = result.toString()
            myIntent.putExtra(RESULT_VALUE_KEY,resultValueConverted)
        }
        else if(spinnerConversionFrom.selectedItem.toString() == "Kilogram"){
            val result = convertFrom(enteredValue.toDouble(), 1000.00)
            val resultValueConverted = result.toString()
            myIntent.putExtra(RESULT_VALUE_KEY,resultValueConverted)
        }
        else if(spinnerConversionFrom.selectedItem.toString() == "Gram"){
            val result = convertTo(enteredValue.toDouble(),1000.00)
            val resultValueConverted = result.toString()
            myIntent.putExtra(RESULT_VALUE_KEY,resultValueConverted)
        }
        else if(spinnerConversionFrom.selectedItem.toString() == "Byte"){
            val result = convertFrom(enteredValue.toDouble(), 8.00)
            val resultValueConverted = result.toString()
            myIntent.putExtra(RESULT_VALUE_KEY,resultValueConverted)
        }
        else if(spinnerConversionFrom.selectedItem.toString() == "Bit"){
            val result = convertTo(enteredValue.toDouble(), 8.00)
            val resultValueConverted = result.toString()
            myIntent.putExtra(RESULT_VALUE_KEY,resultValueConverted)
        }

        //sending values to another activity
        myIntent.putExtra(INPUT_VALUE_KEY,enteredValue)
        myIntent.putExtra(SPINNER_KEY,enteredSpinner)
        myIntent.putExtra(SPINNER_CONVERTED_KEY,resultSpinner)

        startActivity(myIntent)
    }
        //calculating
    private fun CelsiusToKelvin(a: Float): Float{
        return a + 273.15F
    }

    private fun KelvinToCelsius(a: Float) : Float {
        return a - 273.15F
    }

    private fun convertTo(a: Double, b: Double) : Double {
        return a / b
    }

    private fun convertFrom(a: Double, b: Double) : Double {
        return a * b
    }

    private fun spinnFromTemperature() {
        val typesOfUnit = arrayOf("Celsius","Kelvin")
        spinnerConversionFrom.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, typesOfUnit)
        spinnerConversionFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }
    }

    private fun spinToTemperature() {
        val typesOfUnit = arrayOf("Kelvin","Celsius")
        spinnerConversionTo.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, typesOfUnit)
        spinnerConversionTo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }
    }
    private fun spinnFromDistance() {
        val typesOfUnit = arrayOf("Meter","Centimeter")
        spinnerConversionFrom.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, typesOfUnit)
        spinnerConversionFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }
    }


    private fun spinnToDistance() {
        val typesOfUnit = arrayOf("Centimeter","Meter")
        spinnerConversionTo.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, typesOfUnit)
        spinnerConversionTo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }
    }
    private fun spinnFromWeight() {
        val typesOfUnit = arrayOf("Kilogram","Gram")
        spinnerConversionFrom.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, typesOfUnit)
        spinnerConversionFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }
    }

    private fun spinnToWeight() {
        val typesOfUnit = arrayOf("Gram","Kilogram")
        spinnerConversionTo.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, typesOfUnit)
        spinnerConversionTo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }
    }
    private fun spinnFromDigital() {
        val typesOfUnit = arrayOf("Byte","Bit")
        spinnerConversionFrom.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, typesOfUnit)
        spinnerConversionFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }
    }

    private fun spinnToDigital() {
        val typesOfUnit = arrayOf("Bit","Byte")
        spinnerConversionTo.adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, typesOfUnit)
        spinnerConversionTo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }
    }
}
