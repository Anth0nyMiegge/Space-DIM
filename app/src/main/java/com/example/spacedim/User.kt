package com.example.spacedim

import android.os.Parcel
import android.os.Parcelable

data class User(
    val id: Int,
    val name: String,
    val avatar: String,
    val score: Int,
    var state: State = State.OVER)

enum class State {
    OVER, WAITING, READY
}
