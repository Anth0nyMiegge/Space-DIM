package com.example.spacedim

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LobbyViewModel : ViewModel() {
    /* Création d'une LiveData de classe LobbyClass */
    val lobby: MutableLiveData<LobbyClass> by lazy{
        MutableLiveData<LobbyClass>()
    }
}