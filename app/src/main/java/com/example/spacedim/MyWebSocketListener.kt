package com.example.spacedim

import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener

import okio.ByteString

 class MyWebSocketListener(var myCallback: (result: String?) -> Unit) : WebSocketListener( ) {
    private val NORMAL_CLOSURE_STATUS = 1000;

    override fun onOpen(webSocket: WebSocket, response: Response?) {
        webSocket.send("Hello, it's SSaurel !")
        webSocket.send("What's up ?")
        webSocket.send(ByteString.decodeHex("deadbeef"))
        //webSocket.close(NORMAL_CLOSURE_STATUS, "Goodbye !")
    }

    override fun onMessage(webSocket: WebSocket?, text: String) {
        myCallback.invoke("Receiving : $text")
    }

    override fun onMessage(webSocket: WebSocket?, bytes: ByteString) {
        myCallback.invoke("Receiving bytes : " + bytes.hex())
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        webSocket.close(NORMAL_CLOSURE_STATUS, null)
        myCallback.invoke("Closing : $code / $reason")
    }

    override fun onFailure(webSocket: WebSocket?, t: Throwable, response: Response?) {
        myCallback.invoke("Error : " + t.message)
    }



}

class SocketAbortedException : Exception()

data class SocketUpdate(
    val text: String? = null,
    val byteString: ByteString? = null,
    val exception: Throwable? = null
)
