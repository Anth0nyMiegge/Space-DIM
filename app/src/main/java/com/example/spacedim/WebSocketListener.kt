package com.example.spacedim

import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString

class WebSocketListenerCustom() : WebSocketListener() {
    private val NORMAL_CLOSURE_STATUS = 1000

    /* Fonction stipulant ce qui doit être effectué à l'ouverture du socket */
    override fun onOpen(webSocket: WebSocket, response: Response?) {}

    /* Fonction stipulant ce qui doit être effectué à la réception d'un message par le socket (si le message est de type String) */
    override fun onMessage(webSocket: WebSocket?, text: String) {
        // TODO: 1/18/2022 create parser suivant le contenu
        // Moshi
        var event: EventType = EventType.WAITING_FOR_PLAYER
        println("Message reçu : $text")
    }

    /* Fonction stipulant ce qui doit être effectué à la réception d'un message par le socket (si le message est de type ByteString) */
    override fun onMessage(webSocket: WebSocket?, bytes: ByteString) {
        println("Receiving bytes : " + bytes.hex())
    }

    /* Fonction stipulant ce qui doit être effectué à la fermeture du socket */
    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        webSocket.close(NORMAL_CLOSURE_STATUS, null)
        println("Closing : $code / $reason")
    }

    /* Fonction stipulant ce qui doit être effectué à la réception d'une erreur du socket */
    override fun onFailure(webSocket: WebSocket?, t: Throwable, response: Response?) {
        println("Error : " + t.message)
    }


}

class SocketAbortedException : Exception()

data class SocketUpdate(
    val text: String? = null,
    val byteString: ByteString? = null,
    val exception: Throwable? = null
)
