package com.example.jitsu

import android.app.Activity
import android.content.Intent
import android.graphics.Picture
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AddNewStoreActivity : AppCompatActivity() {
    private val pickPhotoRequestCode = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_store)

    val openPicture: Picture = findViewById(R.id.addPhotoImageButton)
        openPicture.setOnClickListener{
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                addCategory(Intent.CATEGORY_OPENABLE)
                setType("image/jpeg")
            }
            startActivityForResult(intent, pickPhotoRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == pickPhotoRequestCode && resultCode == Activity.RESULT_OK) {
            data?.data?.let {
                val imageView = findViewById<ImageView>(R.id.addPhotoImageButton)
                imageView.setImageURI(it)
            }
        }
    }
}