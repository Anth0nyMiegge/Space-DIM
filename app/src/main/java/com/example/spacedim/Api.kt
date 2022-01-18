package com.example.spacedim

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.launch
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.moshi.MoshiConverterFactory

val baseLink = "https://spacedim.async-agency.com/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(baseLink)
    .build()
interface UsersApiService {
    @GET("api/users")
    suspend fun getUsers(): List<User>
    @GET("api/find/user")
    suspend fun getUserByName(): User
    @GET("api/user")
    suspend fun getUserById(): User
}
object UsersApi {
    val retrofitService : UsersApiService by lazy {
        retrofit.create(UsersApiService::class.java) }
}

class OverviewViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    private fun getUsersList() {
        viewModelScope.launch {
            try {
                val result = UsersApi.retrofitService.getUsers()
                _response.value = "Success: ${result.size} users retrieved"
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }

    private fun getUserByName() {
        viewModelScope.launch {
            try {
                val result = UsersApi.retrofitService.getUserByName()
                _response.value = "Success: user \"${result.name}\" retrieved"
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }
}