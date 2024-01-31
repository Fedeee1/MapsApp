package com.example.mapsapp.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mapsapp.R
import com.example.mapsapp.model.Country
import com.example.mapsapp.mapModule.views.MapsActivity

class RecyclerCountriesAdapter(listCountry: List<Country>): RecyclerView.Adapter<RecyclerCountriesAdapter.ViewHolder>() {

    private var listCountries = listCountry

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var txtCountryName: TextView
        var imgOpenMap: ImageView
        var cardCountry: CardView

        init {
            txtCountryName = itemView.findViewById(R.id.txtCountryName)
            imgOpenMap = itemView.findViewById(R.id.imgOpenMap)
            cardCountry = itemView.findViewById(R.id.cardCountry)
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
            val intent = Intent(viewHolder.imgOpenMap.context, MapsActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra("CityName", listCountries[position].city.name)
            intent.putExtra("CityLatitude", listCountries[position].city.latitude)
            intent.putExtra("CityLongitude", listCountries[position].city.longitude)
            intent.putExtra("IsCountry", false)
            viewHolder.imgOpenMap.context.startActivity(intent)
        }

        viewHolder.cardCountry.setOnClickListener{
            val intent = Intent(viewHolder.imgOpenMap.context, MapsActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra("CountryName", listCountries[position].name)
            intent.putExtra("CountryLatitude", listCountries[position].latitude)
            intent.putExtra("CountryLongitude", listCountries[position].longitude)
            intent.putExtra("IsCountry", true)
            viewHolder.imgOpenMap.context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return listCountries.size
    }
}