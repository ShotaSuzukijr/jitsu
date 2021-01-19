package com.example.jitsu.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.jitsu.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val SearchArea: Button = findViewById(R.id.SearchArea)
        val AddFoodMap: Button = findViewById(R.id.AddFoodMap)
        val TextArea: TextView = findViewById(R.id.TextArea)
        SearchArea.setOnClickListener {
            val intent = Intent(this, SearchMapActivity::class.java)
            intent.putExtra("VALUE", TextArea.text.toString())
            startActivity(intent)
    }

        AddFoodMap.setOnClickListener {
            val intent = Intent(this, AddStoreActivity::class.java)
            startActivity(intent)
        }
}
}
