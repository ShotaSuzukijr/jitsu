package com.example.jitsu.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.jitsu.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class SearchMapActivity : AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_map)

        val TextAreaMap: TextView = findViewById(R.id.TextAreaMap)
        val value1 = intent.getStringExtra("AREA")
        TextAreaMap.text = "${value1}"

        // Get the SupportMapFragment and request notification when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

    }
        override fun onMapReady(googleMap: GoogleMap?) {
            googleMap?.apply {
                val sydney = LatLng(35.689,139.691)
                addMarker(
                        MarkerOptions()
                                .position(sydney)
                                .title("Marker in Sydney")
                )
                moveCamera(CameraUpdateFactory.newLatLng(sydney))
            }
        }
}
