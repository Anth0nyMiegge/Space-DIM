package com.example.spacedim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.spacedim.databinding.FragmentLoginBinding
import okhttp3.*
import java.io.IOException
import okhttp3.RequestBody

/*
Structure user :
{
    "id" : 124,
    "name" : "zinedine",
    "avatar" : "http://spacedim.async-agency.com/static/avatar/maya.png",
    "score" : 0,
    "state" : "OVER"
}
*/

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        val buttonLobby = binding.buttonLobby
        val editTextTextPersonName = binding.editTextTextPersonName

        buttonLobby.setOnClickListener {
            view?.findNavController()?.navigate(R.id.login_to_lobby)
//            val body: RequestBody = RequestBody.create(
//                MediaType.parse("application/json"), "{\"name\":\"" + editTextTextPersonName.text + "\"}"
//            )
            println("{\"name\":" + editTextTextPersonName.text + "}")
        //  Appel user/register
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
