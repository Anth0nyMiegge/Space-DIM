package com.example.spacedim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spacedim.databinding.FragmentLobbyBinding

class LobbyFragment : Fragment() {

    private var _binding: FragmentLobbyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val lobbyJoinedFragment = LobbyJoinedFragment()
        addChildFragment(lobbyJoinedFragment, R.id.fragment_container)

        _binding = FragmentLobbyBinding.inflate(inflater, container, false)

        return binding.root
    }
}