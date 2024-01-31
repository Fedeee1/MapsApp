package com.example.mapsapp.mapModule.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mapsapp.R
import com.example.mapsapp.commons.ANIMATION_MAP_ZOOM_DURATION
import com.example.mapsapp.commons.CITY_ZOOM
import com.example.mapsapp.commons.COUNTRY_ZOOM
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private var cityName = " "
    private var cityLatitude = 0.0
    private var cityLongitude = 0.0
    private var isCountry = true
    private var countryName = " "
    private var countryLatitude = 0.0
    private var countryLongitude = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.mapCountry) as SupportMapFragment
        mapFragment.getMapAsync(this)

        initVars()
    }

    private fun initVars(){
        cityName = intent.getStringExtra("CityName").toString()
        cityLatitude = intent.getDoubleExtra("CityLatitude", 0.0)
        cityLongitude = intent.getDoubleExtra("CityLongitude", 0.0)
        isCountry = intent.getBooleanExtra("IsCountry", true)
        countryName = intent.getStringExtra("CountryName").toString()
        countryLatitude = intent.getDoubleExtra("CountryLatitude", 0.0)
        countryLongitude = intent.getDoubleExtra("CountryLongitude", 0.0)

    }
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
       if(isCountry){
           getLocation(countryName, countryLatitude, countryLongitude, true)
       } else {
           getLocation(cityName, cityLatitude, cityLongitude, false)
       }
    }

    private fun getLocation(name: String, lat: Double, long: Double, isCountry: Boolean){
        val coordinates = LatLng(lat, long)
        val city = MarkerOptions().position(coordinates).title(name)
        val zoom: Float =
            if (isCountry){
            COUNTRY_ZOOM
        } else {
            CITY_ZOOM
        }
        map.addMarker(city)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, zoom),
            ANIMATION_MAP_ZOOM_DURATION, null)
    }
}

