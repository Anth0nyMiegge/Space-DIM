package com.example.spacedim

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket

class LobbyClass {
    lateinit var lobbyName:String
    lateinit var userName:String
    var userId:Int = 0
    lateinit var listUser:List<User>
    lateinit var ws:WebSocket

    /* Rejoindre un lobby avec son nom, et l'id de l'utilisateur le rejoignant */
    fun join ( name:String, userId:Int, client: OkHttpClient) {
        val request: Request = Request.Builder().url("ws://spacedim.async-agency.com:8081/ws/join/$name/$userId").build()
        val listener = WebSocketListenerCustom()
        this.ws = client.newWebSocket(request, listener)
    }

    /* Change le statut du joueur l'activant afin qu'il soit READY */
    fun setReady(ready:Boolean){
        var value = "false"
        if (ready)
            value = "true"
        this.ws.send("{\"type\":\"READY\", \"value\":$value}")
    }

    /* Fonction incomplete : obtenir tous les lobbys existants */
    fun getAllLobby():String{
        // TODO: 1/17/2022 get + parse list lobby
        return "todo"
    }

    /* Fonction incomplete : obtenir le statut du joueur connecté */
    fun getStatutPlayer():String {
        var lobby = getStatutLobby();
        // TODO: 1/17/2022 parsing info player
        return "todo"
    }

    /* Fonction incomplete : savoir si la partie est prête à être lancée (true = lancement de la partie) */
    fun getStatutLobby():String {
        // TODO: 1/17/2022 call ws + parsing info
        return "todo"
    }
}