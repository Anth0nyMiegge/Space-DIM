package com.example.spacedim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import okhttp3.OkHttpClient
import com.example.spacedim.databinding.FragmentLobbyBinding

class LobbyFragment : Fragment() {

    private var modelLobby:LobbyViewModel = LobbyViewModel()

    private var _binding: FragmentLobbyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val lobby:LobbyClass = LobbyClass()
        lobby.join("room",1, OkHttpClient())
        modelLobby.lobby.value = lobby


        //DEBUG
        // TODO: 1/18/2022 Delete this thing when we have onclick ready.
        //send ready action to web socket
        modelLobby.lobby.value?.setReady(true)
        //\DEBUG

        val lobbyJoinedFragment = LobbyJoinedFragment()
        addChildFragment(lobbyJoinedFragment, R.id.fragment_container)

        _binding = FragmentLobbyBinding.inflate(inflater, container, false)

        return binding.root
    }
}