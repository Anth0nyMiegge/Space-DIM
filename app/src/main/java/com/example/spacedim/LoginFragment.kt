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
            val body: RequestBody = RequestBody.create(
                MediaType.parse("application/json"),
                "{\"name\":\"" + editTextTextPersonName.text + "\"}"
            )
            println("{\"name\":" + editTextTextPersonName.text + "}")
            post(baseLink + "api/user/register", body)
        }

        return binding.root
    }
    private val client = OkHttpClient()
    private val baseLink = "https://spacedim.async-agency.com/"

    private fun get(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) = println(response.body()?.string())
        })
    }

    private fun post(url: String, body: RequestBody) {
        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) = println(response.body()?.string())
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
