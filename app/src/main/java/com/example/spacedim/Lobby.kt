package com.example.spacedim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Lobby : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lobby)
        var buttonJoinLobby = findViewById<Button>(R.id.buttonJoinLobby)
        buttonJoinLobby.setOnClickListener {
            startActivity(Intent(this, Lobby_Joined::class.java))
        }
    }
}