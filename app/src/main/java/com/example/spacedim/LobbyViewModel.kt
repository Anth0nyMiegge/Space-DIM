package com.example.spacedim

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LobbyViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    // Create a LiveData with a String
    val lobbyName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val socketStatut: MutableLiveData<Boolean> by lazy{
        MutableLiveData<Boolean>()
    }




}