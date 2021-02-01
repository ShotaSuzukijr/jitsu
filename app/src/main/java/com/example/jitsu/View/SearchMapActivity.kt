package com.example.jitsu.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.jitsu.R

class SearchMapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_map)

        val TextAreaMap: TextView = findViewById(R.id.TextAreaMap)
        val value1 = intent.getStringExtra("VALUE")
        TextAreaMap.text = "${value1}"
    }
}