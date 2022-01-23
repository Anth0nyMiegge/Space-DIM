package com.example.spacedim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spacedim.databinding.ActivityMainBinding

/* Seule activité instanciée : le choix des fragments a été fait pour des raisons de performances */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}