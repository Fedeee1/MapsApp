package com.example.mapsapp.model

data class Country(
    var name: String,
    var latitude: Double,
    var longitude: Double,
    var city: City,
)
