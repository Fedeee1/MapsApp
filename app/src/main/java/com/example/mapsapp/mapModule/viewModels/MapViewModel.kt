package com.example.mapsapp.mapModule.viewModels

import androidx.lifecycle.ViewModel
import com.example.mapsapp.model.City
import com.example.mapsapp.model.Country
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MapViewModel() : ViewModel(){

    private var listCountries: MutableList<Country> = mutableListOf()

    var listCountriesFlow : Flow<List<Country>> = flow {
        listCountries.add(Country("España",    39.487688, -3.329312, City("Madrid",40.4165, -3.70256)))
        listCountries.add(Country("Grecia",39.63689, 22.41761, City("Atenas",37.98376, 23.72784)))
        listCountries.add(Country("Francia",46.631562, 2.455594 , City("París",48.85341, 2.3488)))
        listCountries.add(Country("Italia", 43.026987, 12.458934 , City("Roma", 41.900905, 12.495224)))
        listCountries.add(Country("Portugal", 39.670077, -8.756265, City("Lisboa", 38.724021, -9.143980)))
        emit(listCountries)
    }
}