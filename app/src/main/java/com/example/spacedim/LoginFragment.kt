package com.example.spacedim

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_login, container, false)
        var editTextTextPersonName = v.findViewById<EditText>(R.id.editTextTextPersonName)
        var buttonLobby = v.findViewById<ImageButton>(R.id.buttonLobby)
        buttonLobby.setOnClickListener {
            val body: RequestBody = RequestBody.create(
                MediaType.parse("application/json"), "{\"name\":\""+ editTextTextPersonName.text +"\"}"
            )
            println("{\"name\":"+ editTextTextPersonName.text +"}")
            post(baseLink + "api/user/register", body)
        }
        return v
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
}
