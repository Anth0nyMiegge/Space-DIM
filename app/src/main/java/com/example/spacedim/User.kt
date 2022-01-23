package com.example.spacedim

/* Classe définissant les attributs d'un utilisateur tel que renvoyé par l'API */
data class User(val id: Int,
                val name: String,
                val avatar: String,
                var score: Int,
                var state: State = State.OVER)

enum class State(val value: Int) {
    WAITING(0), READY(1), IN_GAME(2), OVER(3)
}

/* Classe définie uniquement pour servir à l'inscription d'un utilisateur (car demandée par l'API) */
data class UserPost(val name: String)
