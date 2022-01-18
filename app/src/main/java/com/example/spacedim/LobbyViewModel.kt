package com.example.spacedim

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LobbyViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    // Create a LiveData with a Class
    val lobby: MutableLiveData<LobbyClass> by lazy{
        MutableLiveData<LobbyClass>()
    }





}