package com.example.spacedim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var buttonLobby = findViewById<ImageButton>(R.id.buttonLobby)
        buttonLobby.setOnClickListener {
            startActivity(Intent(this, Lobby::class.java))
        }
    }
}