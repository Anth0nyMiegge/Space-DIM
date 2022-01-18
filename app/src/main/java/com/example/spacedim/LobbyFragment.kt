package com.example.spacedim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import okhttp3.OkHttpClient

class LobbyFragment : Fragment() {
    var modelLobby:LobbyViewModel = LobbyViewModel();
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var lobby:LobbyClass = LobbyClass()
        lobby.join("room",1, OkHttpClient())
        modelLobby.lobby.setValue(lobby);


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lobby, container, false)


    }
}