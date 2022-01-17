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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        var request:Request = Request.Builder().url("ws://echo.websocket.org").build();
        var listener:MyWebSocketListener  = MyWebSocketListener{ result: String? ->
            println(result);
        };
        var ws:WebSocket = client.newWebSocket(request, listener);
        client.dispatcher().executorService().shutdown();
    }

}