package mvrataric.ferit.hr.unit_conversion_calculator

/**
 * Created by marina on 4/9/2019.
 */
object UnitRepository{

    val myUnit: MutableList<UnitView>

    init {
        myUnit = myListOfUnits()
    }

    private fun myListOfUnits(): MutableList<UnitView> {
        return mutableListOf(
                UnitView(1,"Temperature","https://cdn4.iconfinder.com/data/icons/tourism-and-travel-objects/512/temperature_thermometer_heat_measuring_travel_tourism_flat_icon_symbol-512.png"),
                UnitView(2,"Distance","https://cdn3.iconfinder.com/data/icons/maps-and-navigation-flat-icons-vol-1/256/05-512.png"),
                UnitView(3,"Weight","https://cdn4.iconfinder.com/data/icons/finance-and-money/512/scale_justice_law_legal_item_weight_flat_icon_symbol-512.png"),
                UnitView(4,"Digital","https://cdn3.iconfinder.com/data/icons/bitcoin-cryptocurrency/512/Icon_35-512.png")

        )
    }
}