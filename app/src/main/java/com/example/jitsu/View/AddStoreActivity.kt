package com.example.jitsu.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jitsu.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddStoreActivity : AppCompatActivity() {
    private val addActivityRequestCode = 1
    private lateinit var viewModel: PhotoViewModel

    val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
    val adapter = PhotoListAdapter(this)
    recyclerView.adapter = adapter
    recyclerView.layoutManager = LinearLayoutManager(this)

    viewModel = ViewModelProvider(this).get(PhotoViewModel::
    class.java)
    viewModel.allPhotos.observe(this, Observer
    {
        photos ->
        photos?.let { adapter.setPhotos(it) }
    })


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_store)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@AddStoreActivity, AddNewStoreActivity::class.java)
            startActivityForResult(intent, addActivityRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == addActivityRequestCode) {
            if(resultCode != Activity.RESULT_OK) {
                Toast.makeText(
                    applicationContext,
                    “Photo additions have been cancelled.",
                    Toast.LENGTH_LONG
                ).show()
    }
}