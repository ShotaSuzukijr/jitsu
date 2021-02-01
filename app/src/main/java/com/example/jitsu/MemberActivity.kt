package com.example.jitsu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.jitsu.View.AddStoreActivity
import com.example.jitsu.View.MainActivity

class MemberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member)

        val textUser: TextView = findViewById(R.id.textUser)
        val logoutButton: Button = findViewById(R.id.loginButton)
        val value4 = intent.getStringExtra("VALUE2")
        textUser.text = "${value4}"

        logoutButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}