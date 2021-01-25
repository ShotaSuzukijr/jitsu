package com.example.jitsu.View

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jitsu.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.nio.file.Files.delete

class   AddStoreActivity : AppCompatActivity() {
    private val addActivityRequestCode = 1
    private lateinit var viewModel: PhotoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_store)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = FoodListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel  = ViewModelProvider(this).get(PhotoViewModel::class.java)
        viewModel.allPhotos.observe(this, Observer { photos ->
            photos?.let { adapter.setPhotos(it)}
        })

        val back: ImageButton = findViewById(R.id.backToMainImage)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@AddStoreActivity, AddNewStoreActivity::class.java)
            startActivityForResult(intent, addActivityRequestCode)
        }

        back.setOnClickListener {
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == addActivityRequestCode) {
            if(resultCode != Activity.RESULT_OK) {
                Toast.makeText(
                        applicationContext,
                        "Photo additions have been canselled.",
                        Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    val touchHelper = ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                override fun onMove(
                        view: RecyclerView,
                        holder: RecyclerView.ViewHolder,
                        target: RecyclerView.ViewHolder): Boolean {
                    return false
                }

                override fun onSwiped(holder: RecyclerView.ViewHolder, direction: Int) {
                }
            }
    )
}