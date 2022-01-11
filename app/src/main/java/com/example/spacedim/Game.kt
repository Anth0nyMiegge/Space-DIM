package com.example.spacedim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        var buttonWin = findViewById<Button>(R.id.buttonWin)
        buttonWin.setOnClickListener {
            startActivity(Intent(this, Win::class.java))
        }
        //test de pull
        var buttonLose = findViewById<Button>(R.id.buttonLose)
        buttonLose.setOnClickListener {
            startActivity(Intent(this, Lose::class.java))
        }
    }
}