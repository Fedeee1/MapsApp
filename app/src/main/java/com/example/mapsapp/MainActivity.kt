package com.example.mapsapp

/*
aparece un listado de paises en una tabla.
En cada celda aparece el nombre del pais y un boton.
Si se pulsa sobre la celda, en otra pantalla aparece el mapa del pais.
Sii se pulsa sobre el boton de la celda, aparece en otra pantalla un mapa de una ciudad del pais,
me da lo mismo la capital, la ciudad que querais, me da lo mismo, el objetivo no es el mapa,
el objetivo es que controleis el boton de la celda y la celda como tal
 */

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mapsapp.adapters.RecyclerCountriesAdapter
import com.example.mapsapp.mapModule.viewModels.MapViewModel
import androidx.lifecycle.viewModelScope
import com.example.mapsapp.model.Country
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    companion object{
        lateinit var context: Context
    }

    private val viewModel by viewModels<MapViewModel>()
    private lateinit var recyclerCountries: RecyclerView
    private var listCountries: List<Country> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        context = applicationContext

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.viewModelScope.launch {
            viewModel.listCountriesFlow.collect{
                listCountries = it
            }
        }
        initAdapter(listCountries)
    }

    private fun initAdapter(listCountries: List<Country>){
        recyclerCountries = findViewById(R.id.recyclerCountries)
        val adapter = RecyclerCountriesAdapter(listCountries)
        recyclerCountries.layoutManager = LinearLayoutManager(this)
        recyclerCountries.adapter = adapter
    }

}