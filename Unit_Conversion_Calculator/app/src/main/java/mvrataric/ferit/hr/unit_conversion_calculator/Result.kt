package mvrataric.ferit.hr.unit_conversion_calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        setUpUi()
    }

    private fun setUpUi() {
        //show entered value
        val getInput = intent.getStringExtra("1")
        tvResultFrom.text = getInput

        //show spinner from value
        val getSpinner = intent.getStringExtra("3")
        tvResultMeasureFrom.text = getSpinner

        //show converted value
        val getResult = intent.getStringExtra("2")
        tvResultTo.text = getResult

        //show spinner to value
        val getSpinnerResult = intent.getStringExtra("4")
        tvResultMeasureTo.text = getSpinnerResult
    }
}
