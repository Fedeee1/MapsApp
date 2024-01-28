package com.example.mapsapp.views

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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mapsapp.R
import com.example.mapsapp.adapters.RecyclerCountriesAdapter

class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var context: Context
    }

    private lateinit var recyclerCountries: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        context = applicationContext

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAdapter()
    }

    private fun initAdapter(){
        recyclerCountries = findViewById(R.id.recyclerCountries)
        val adapter = RecyclerCountriesAdapter()
        recyclerCountries.layoutManager = LinearLayoutManager(this)
        recyclerCountries.adapter = adapter
    }
}