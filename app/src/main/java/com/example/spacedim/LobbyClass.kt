package com.example.spacedim

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import java.net.Socket

class LobbyClass {
    public lateinit var lobbyName:String ;
    public lateinit var userName:String ;
    public var userId:Int = 0;

    public lateinit var ws:WebSocket;

    // can join a lobby with it's name
    fun join ( name:String, userId:Int, client: OkHttpClient) {
        // TODO: 1/17/2022 make lobby join

        val request: Request = Request.Builder().url("ws://spacedim.async-agency.com:8081/ws/join/$name/$userId").build();
        val listener:MyWebSocketListener  = MyWebSocketListener();
        this.ws = client.newWebSocket(request, listener);
    }



    fun setReady(ready:Boolean){
        // TODO: 1/18/2022 send ready or not ready
        this.ws.send("{\"type\":\"READY\", \"value\":true}");


    }


    
    fun getAllLobby():String{
        // TODO: 1/17/2022 get + parse list lobby
        return "todo";
    }


    
    //get le statut du joueur
    fun getStatutPlayer():String {
        var lobby = getStatutLobby();
        // TODO: 1/17/2022 parsing info player
        return "todo";
    }


    
    //get state all lobby player
    fun getStatutLobby():String {
        // TODO: 1/17/2022 call ws + parsing info
        return "todo";
    }
    
    

}