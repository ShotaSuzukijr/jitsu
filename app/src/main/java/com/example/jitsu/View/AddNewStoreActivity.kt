package com.example.jitsu.View

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jitsu.R

class AddNewStoreActivity : AppCompatActivity() {
    private val pickPhotoRequestCode = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_store)

    val openPicture: ImageButtom = findViewById(R.id.addPhotoImageButton)
        openPicture.setOnClickListener{
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                addCategory(Intent.CATEGORY_OPENABLE)
                setType("image/jpeg")
            }
            startActivityForResult(intent, pickPhotoRequestCode)
        }

    val saveButton: Button = findViewById(R.id.addPhotoMemoSaveButton) saveButton.setOnClickListener {
        val editText = findViewById<EditText>(R.id.addPhotoMemoEditText) val replyIntent = Intent()
        if (imageUri == null || TextUtils.isEmpty(editText.text)) {
            setResult(Activity.RESULT_CANCELED, replyIntent) } else {
            val photo = Photo(imageUri.toString(), editText.text.toString()) viewModel.insert(photo)
            setResult(Activity.RESULT_OK, replyIntent)
        }
        finish()
    }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == pickPhotoRequestCode && resultCode == Activity.RESULT_OK) {
            data?.data?.let {
                if (android.os.Build.VERSION.SDK_INT >=
                    android.os.Build.VERSION_CODES.R)
                    contentResolver.takePersistableUriPermission( it, Intent.FLAG_GRANT_READ_URI_PERMISSION)
                val imageView = findViewById<ImageView>(R.id.addPhotoImageButton)
                imageView.setImageURI(it)
            }
        }
    }
}