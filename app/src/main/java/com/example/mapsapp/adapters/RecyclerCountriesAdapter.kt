package com.example.mapsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.mapsapp.R

class RecyclerCountriesAdapter: RecyclerView.Adapter<RecyclerCountriesAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var txtCountryName: TextView
        var imgOpenMap: ImageView

        init {
            txtCountryName = itemView.findViewById(R.id.txtCountryName)
            imgOpenMap = itemView.findViewById(R.id.imgOpenMap)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_countries, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.txtCountryName.text = "España"
        viewHolder.imgOpenMap.setOnClickListener {

        }
    }
    override fun getItemCount(): Int {
        return 4
    }


}