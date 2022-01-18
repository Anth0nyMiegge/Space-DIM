package com.example.spacedim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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


        println("localoca");

        var client = OkHttpClient();
        //start(client);
        println("###############/n###########");
        var request:Request = Request.Builder().url("ws://echo.websocket.org").build();
        var listener:MyWebSocketListener  = MyWebSocketListener{ result: String? ->
            println(result);
        };
        var ws:WebSocket = client.newWebSocket(request, listener);
        //client.dispatcher().executorService().shutdown();
        ws.send("test envoi");

        




    }
    private fun registrer(result:String){
        println(result);
    }
    private fun start(client:OkHttpClient) {
        var request:Request = Request.Builder().url("ws://spacedim.async-agency.com:8081/ws/join/fgh/1").build();
        var listener:MyWebSocketListener  = MyWebSocketListener{ result: String? ->
            println("##########################");
            println("        $result");
            println("##########################");
        };
        var ws:WebSocket = client.newWebSocket(request, listener);
        //client.dispatcher().executorService().shutdown();
    }

}