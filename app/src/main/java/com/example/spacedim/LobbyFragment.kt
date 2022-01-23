package com.example.spacedim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import okhttp3.OkHttpClient
import com.example.spacedim.databinding.FragmentLobbyBinding

class LobbyFragment : Fragment() {

    private var _binding: FragmentLobbyBinding? = null
    private val binding get() = _binding!!

    private var modelLobby:LobbyViewModel = LobbyViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLobbyBinding.inflate(inflater, container, false)

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

        val buttonJoinLobby = binding.buttonJoinLobby

        buttonJoinLobby.setOnClickListener {
            view?.findNavController()?.navigate(R.id.lobbyToGame)
        }

        return binding.root
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}