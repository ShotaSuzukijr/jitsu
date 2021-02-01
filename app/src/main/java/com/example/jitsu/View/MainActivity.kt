package com.example.jitsu.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jitsu.FoodListAdapter
import com.example.jitsu.R

class MainActivity : AppCompatActivity() {
    private val mainActivityRequestCode = 2



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val SearchArea: Button = findViewById(R.id.SearchArea)
        val AddFoodMap: Button = findViewById(R.id.AddFoodMap)
        val TextArea: EditText = findViewById(R.id.editTextArea)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerviewMain)
        val adapter = FoodListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

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
