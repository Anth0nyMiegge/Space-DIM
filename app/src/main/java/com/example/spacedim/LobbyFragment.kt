package com.example.spacedim

import android.os.Bundle
import android.os.Debug
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


        //DEBUG
        // TODO: 1/18/2022 Delete this thing when we have onclick ready.
        //send ready action to web socket
        modelLobby.lobby.value?.setReady(true);
        //\DEBUG


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lobby, container, false)


    }
}