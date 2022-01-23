package com.example.spacedim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.spacedim.databinding.FragmentLoginBinding

/* Premier fragment visible : permet de se connecter avec un name */
class LoginFragment : Fragment() {

    /* Instantiation du ViewModel */
    private val mod = OverviewViewModel()

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        /* Instantiation des éléments de la vue */
        val buttonLobby = binding.buttonLobby
        val editTextTextPersonName = binding.editTextTextPersonName
        val nickname = editTextTextPersonName.text

        /* Instantiation du UserPost nécéssaire à la requête d'inscription */
        val userpost = UserPost(nickname.toString())

        /* Listener pour passer sur l'écran suivant ET enregistrer/connecter l'utilisateur
          (L'appel à la fonction de connection est située directement dans la fonction d'inscription)*/
        buttonLobby.setOnClickListener {
            view?.findNavController()?.navigate(R.id.login_to_lobby)
            mod.registerNewUser(userpost)
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
