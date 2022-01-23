package com.example.spacedim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.spacedim.databinding.FragmentLoseBinding

class LoseFragment : Fragment() {

    private var _binding: FragmentLoseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val buttonMenu = binding.buttonMenu

        buttonMenu.setOnClickListener {
            view?.findNavController()?.navigate(R.id.lose_to_login)
        }

        _binding = FragmentLoseBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}