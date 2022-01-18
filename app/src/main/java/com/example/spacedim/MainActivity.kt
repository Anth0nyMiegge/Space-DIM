package com.example.spacedim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

import com.example.spacedim.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        val client = OkHttpClient();
        var ws = connectTolobby(client,"nameoflobby",1);


    }

    private fun connectTolobby(client:OkHttpClient, lobbyName:String, userid:Int): WebSocket {
        val request:Request = Request.Builder().url("ws://spacedim.async-agency.com:8081/ws/join/$lobbyName/$userid").build();
        val listener:MyWebSocketListener  = MyWebSocketListener();
        val ws:WebSocket = client.newWebSocket(request, listener);
        return ws;
        //client.dispatcher().executorService().shutdown();
    }

}