package com.example.spacedim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.spacedim.databinding.FragmentGameBinding

/* Pour l'instant, simple transformation du TP Noël de Anthony en fragment */
class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentGameBinding.inflate(inflater, container, false)

        val buttonWin = binding.buttonWin
        val buttonLose = binding.buttonLose

        /* Listener sur le bouton pour gagner */
        buttonWin.setOnClickListener {
            view?.findNavController()?.navigate(R.id.game_to_win)
        }

        /* Listener sur le bouton pour perdre */
        buttonLose.setOnClickListener {
            view?.findNavController()?.navigate(R.id.game_to_lose)
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

