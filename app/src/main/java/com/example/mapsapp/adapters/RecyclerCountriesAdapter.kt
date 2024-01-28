package com.example.mapsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.mapsapp.R
import com.example.mapsapp.model.Country

class RecyclerCountriesAdapter: RecyclerView.Adapter<RecyclerCountriesAdapter.ViewHolder>() {
    var listCountries: MutableList<Country> = mutableListOf()
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var txtCountryName: TextView
        var imgOpenMap: ImageView

        init {
            txtCountryName = itemView.findViewById(R.id.txtCountryName)
            imgOpenMap = itemView.findViewById(R.id.imgOpenMap)
            listCountries.add(Country("España", "Madrid"))
            listCountries.add(Country("Grecia", "Atenas"))
            listCountries.add(Country("Francia", "París"))
            listCountries.add(Country("Italia", "Roma"))
            listCountries.add(Country("Portugal", "Lisboa"))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_countries, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.txtCountryName.text = listCountries[position].name
        viewHolder.txtCountryName.text = listCountries[position].name
        viewHolder.txtCountryName.text = listCountries[position].name
        viewHolder.txtCountryName.text = listCountries[position].name
        viewHolder.txtCountryName.text = listCountries[position].name
            viewHolder.imgOpenMap.setOnClickListener {

        }
    }
    override fun getItemCount(): Int {
        return 5
    }


}