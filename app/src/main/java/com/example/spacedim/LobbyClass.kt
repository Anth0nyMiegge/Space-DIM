package com.example.spacedim

class LobbyClass {
    public var name:String = "";
    public var ws:String = "";

    // permet de rejoindre un lobby via son nom
    fun join ( lobbyName:String): Boolean {
        var success:Boolean = false;
        // TODO: 1/17/2022 code lobby join
        if(success){
            this.name = lobbyName;
        }
        return success
    }
    
    fun getAllLobby():String{
        // TODO: 1/17/2022 recup + parse liste lobby 
        return "todo";
    }
    
    //recupere le statut du joueur
    fun getStatutPlayer():String {
        var lobby = getStatutLobby();
        // TODO: 1/17/2022 separer info du joueur
        return "todo";
    }
    
    //recupere le statut de tout le lobby
    fun getStatutLobby():String {
        // TODO: 1/17/2022 appel ws + parsing info
        return "todo";
    }
    
    

}