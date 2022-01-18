package com.example.spacedim

import androidx.activity.viewModels
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener

import okio.ByteString

 class MyWebSocketListener() : WebSocketListener( ) {
    private val NORMAL_CLOSURE_STATUS = 1000;
     private val model: LobbyViewModel = LobbyViewModel()

     override fun onOpen(webSocket: WebSocket, response: Response?) {
        /*myCallback.invoke("Connexion REUSSI")
        webSocket.send("Hello, it's SSaurel !")
        webSocket.send("What's up ?")
        webSocket.send(ByteString.decodeHex("deadbeef"))
        //webSocket.close(NORMAL_CLOSURE_STATUS, "Goodbye !")*/
         model.socketStatut.postValue(true);
    }

    override fun onMessage(webSocket: WebSocket?, text: String) {
        // TODO: 1/18/2022 create parser suivant le contenu
        println("Message reçu$text");
    }

    override fun onMessage(webSocket: WebSocket?, bytes: ByteString) {
        println("Receiving bytes : " + bytes.hex())
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        webSocket.close(NORMAL_CLOSURE_STATUS, null)
        println("Closing : $code / $reason")
        model.socketStatut.postValue(false);
    }

    override fun onFailure(webSocket: WebSocket?, t: Throwable, response: Response?) {
        println("Error : " + t.message)
        model.socketStatut.postValue(false);
    }


}


class SocketAbortedException : Exception()

data class SocketUpdate(
    val text: String? = null,
    val byteString: ByteString? = null,
    val exception: Throwable? = null
)
