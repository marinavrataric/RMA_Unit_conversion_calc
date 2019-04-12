package mvrataric.ferit.hr.unit_conversion_calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_menu_measurement.*

class MenuMeasurementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_measurement)
        setOnUi()
    }

    private fun setOnUi() {
        rvItem.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL, false)
        rvItem.adapter = MyAdapter(UnitRepository.myUnit)
    }
}
