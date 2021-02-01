package com.example.jitsu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jitsu.View.AddStoreActivity
import com.example.jitsu.View.SearchMapActivity

class ExmHomeActivity : AppCompatActivity() {
    private val mainActivityRequestCode = 2
    private lateinit var viewModel: PhotoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exm_home)

        val SearchArea: Button = findViewById(R.id.SearchArea)
        val AddFoodMap: Button = findViewById(R.id.AddFoodMap)
        val MemberButton: Button = findViewById(R.id.MemberButton)
        val TextArea: EditText = findViewById(R.id.editTextArea)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerviewMain)
        val adapter = FoodListAdapter(this)
        val textName: TextView = findViewById(R.id.textName)
        val value3 = intent.getStringExtra("USER")
        textName.text = "${value3}"

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel  = ViewModelProvider(this).get(PhotoViewModel::class.java)
        viewModel.allPhotos.observe(this, Observer { photos ->
            photos?.let { adapter.setPhotos(it)}
        })

        SearchArea.setOnClickListener {
            val intent = Intent(this, SearchMapActivity::class.java)
            intent.putExtra("AREA", TextArea.text.toString())
            startActivity(intent)
        }

        AddFoodMap.setOnClickListener {
            val intent = Intent(this, AddStoreActivity::class.java)
            startActivity(intent)
        }

        MemberButton.setOnClickListener {
            val intent = Intent(this, MemberActivity::class.java)
            intent.putExtra("USER1", textName.text.toString())
            startActivity(intent)
        }


    }
}
