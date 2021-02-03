package com.example.jitsu.View

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.insert
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import com.example.jitsu.AddPhotoViewModel
import com.example.jitsu.Photo
import com.example.jitsu.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class AddNewStoreActivity : AppCompatActivity(), OnMapReadyCallback {
    private val pickPhotoRequestCode = 2
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_store)

    val openButton: Button = findViewById(R.id.addPhotoMemoOpenButton)
        openButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                addCategory(Intent.CATEGORY_OPENABLE)
                setType("image/jpeg")
            }
            startActivityForResult(intent, pickPhotoRequestCode)
        }

    val saveButton: Button = findViewById(R.id.addPhotoMemoSaveButton)
    saveButton.setOnClickListener {
        val editText = findViewById<EditText>(R.id.addPhotoMemoEditText)
        val editPrice = findViewById<EditText>(R.id.editTextPrice)
        val editTime = findViewById<EditText>(R.id.editTextDate)
        val replyIntent = Intent()

        if (imageUri == null || TextUtils.isEmpty(editText.text)) {
            setResult(Activity.RESULT_CANCELED, replyIntent) } else {
            val photo = Photo(imageUri.toString(),
                    editText.text.toString(),
                    editPrice.text.toString(),
                    editTime.text.toString())
            val viewModel = ViewModelProvider(this).get(AddPhotoViewModel::class.java)
            viewModel.insert(photo)
            setResult(Activity.RESULT_OK, replyIntent)
        }
        finish()
    }
        // Get the SupportMapFragment and request notification when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapView) as? SupportMapFragment
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == pickPhotoRequestCode && resultCode == Activity.RESULT_OK) {
            data?.data?.let {
                if (android.os.Build.VERSION.SDK_INT >=
                    android.os.Build.VERSION_CODES.R)
                    contentResolver.takePersistableUriPermission(
                        it, Intent.FLAG_GRANT_READ_URI_PERMISSION)
                val imageView = findViewById<ImageView>(R.id.addPhotoMemoImageView)
                imageView.setImageURI(it)
                imageUri = it
            }
        }
    }
}