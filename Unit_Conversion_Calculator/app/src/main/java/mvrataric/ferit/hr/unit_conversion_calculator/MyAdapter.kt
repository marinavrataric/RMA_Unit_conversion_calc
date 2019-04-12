package mvrataric.ferit.hr.unit_conversion_calculator

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_conversion.view.*
import kotlinx.android.synthetic.main.activity_menu_measurement.view.*
import kotlinx.android.synthetic.main.unit_layout.view.*

/**
 * Created by marina on 4/9/2019.
 */
class MyAdapter(unit: MutableList<UnitView>): RecyclerView.Adapter<MyViewHolder>(){
    val myUnit: MutableList<UnitView>

    init {
        myUnit = mutableListOf()
        myUnit.addAll(unit)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val myInflater = LayoutInflater.from(parent?.context)
        val viewInflater = myInflater.inflate(R.layout.unit_layout, parent, false)
        return MyViewHolder(viewInflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        val getItem = myUnit[position]
        holder?.bind(getItem)
        holder?.setOnClick()
    }

    override fun getItemCount(): Int {
        return myUnit.size
    }
}

class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
    fun bind(myUnit: UnitView){
        Picasso.get()
                .load(myUnit.image_url)
                .fit()
                .error(R.drawable.abc_list_focused_holo)
                .into(itemView.iwItem)

        itemView.tvItemDescription.text = myUnit.name
    }

    fun setOnClick(){
        itemView.iwItem.setOnClickListener { onClick() }
    }

    private fun onClick() {
        val myIntent = Intent(itemView.context, Conversion::class.java)
        val description = itemView.tvItemDescription.text
        myIntent.putExtra("KEY_EXTRA",description)
        itemView.context.startActivity(myIntent)
    }
}
