package com.example.spacedim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /* val buttonLobby = findViewById<ImageButton>(R.id.buttonLobby)
        buttonLobby.setOnClickListener {
            startActivity(Intent(this, Lobby::class.java))
        }
        */

        return inflater.inflate(R.layout.fragment_login, container, false)
    }
}
