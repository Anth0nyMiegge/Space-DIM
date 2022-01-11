package com.example.spacedim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Lobby_Joined : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lobby_joined)
        var buttonStartGame = findViewById<Button>(R.id.buttonStartGame)
        buttonStartGame.setOnClickListener {
            startActivity(Intent(this, Game::class.java))
        }
    }
}