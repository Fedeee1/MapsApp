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
import com.example.mapsapp.model.City
import com.example.mapsapp.model.Country
import com.example.mapsapp.views.MapsActivity

class RecyclerCountriesAdapter: RecyclerView.Adapter<RecyclerCountriesAdapter.ViewHolder>() {

    var listCountries: MutableList<Country> = mutableListOf()
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var txtCountryName: TextView
        var imgOpenMap: ImageView
        var cardCountry: CardView

        init {
            txtCountryName = itemView.findViewById(R.id.txtCountryName)
            imgOpenMap = itemView.findViewById(R.id.imgOpenMap)
            cardCountry = itemView.findViewById(R.id.cardCountry)
            listCountries.add(Country("España",	39.487688, -3.329312, City("Madrid",40.4165, -3.70256)))
            listCountries.add(Country("Grecia",39.63689, 22.41761, City("Atenas",37.98376, 23.72784)))
            listCountries.add(Country("Francia",46.631562, 2.455594 ,City("París",48.85341, 2.3488)))
            listCountries.add(Country("Italia", 43.026987, 12.458934 ,City("Roma", 41.900905, 12.495224)))
            listCountries.add(Country("Portugal", 39.670077, -8.756265, City("Lisboa", 38.724021, -9.143980)))
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
        return 5
    }
}