package com.example.spacedim

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spacedim.databinding.FragmentWinBinding

/* Fragment encore inutilisé */
class WinFragment : Fragment() {

    private var _binding: FragmentWinBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        /* Tentative de faire fonctionner le bouton de retour au menu principal, sans succès pour une raison inconnue */

//        val buttonMenu = binding.buttonMenu
//
//        buttonMenu.setOnClickListener {
//            view?.findNavController()?.navigate(R.id.win_to_login)
//        }

        _binding = FragmentWinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}