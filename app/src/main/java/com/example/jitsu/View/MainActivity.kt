package com.example.jitsu.View

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
import com.example.jitsu.ExmHomeActivity
import com.example.jitsu.FoodListAdapter
import com.example.jitsu.PhotoViewModel
import com.example.jitsu.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editUser: EditText = findViewById(R.id.editUser)
        val loginButton: Button = findViewById(R.id.loginButton)


        loginButton.setOnClickListener {
            val intent = Intent(this, ExmHomeActivity::class.java)
            intent.putExtra("VALUE", editUser.text.toString())
            startActivity(intent)
    }

}
}
