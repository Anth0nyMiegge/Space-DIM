package com.example.spacedim

import android.content.Context
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
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.POST

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
    @GET("api/find/user/{name}")
    suspend fun getUserByName(name: String): User
    @GET("api/user/{id}")
    suspend fun getUserById(id: Int): User
    @POST("api/user/register")
    suspend fun registerNewUser(userPost: UserPost): Response<UserPost>
}
object UsersApi {
    val retrofitService : UsersApiService by lazy {
        retrofit.create(UsersApiService::class.java) }
}

class OverviewViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response
    var status: Boolean = false

    fun getUsersList() {
        viewModelScope.launch {
            try {
                val result = UsersApi.retrofitService.getUsers()
                _response.value = "Success: ${result.size} users found"
                println(_response.value)
                status = true
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
                println(_response.value)
                status = false
            }
        }
    }

    fun getUserByName(name: String) {
        viewModelScope.launch {
            try {
                val result = UsersApi.retrofitService.getUserByName(name)
                _response.value = "Success: user with ID \"${result.id}\" retrieved"
                println(_response.value)
                status = true
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
                println(_response.value)
                status = false
            }
        }
    }

    fun getUserById(id: Int) {
        viewModelScope.launch {
            try {
                val result = UsersApi.retrofitService.getUserById(id)
                _response.value = "Success: user with name \"${result.name}\" retrieved"
                println(_response.value)
                status = true
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
                println(_response.value)
                status = false
            }
        }
    }

    fun registerNewUser(userPost: UserPost) {
        viewModelScope.launch {
            try {
                val result = UsersApi.retrofitService.registerNewUser(userPost)
                _response.value = "Successfuly registered"
                println(_response.value)
                status = true
            } catch (e: Exception) {
                _response.value = "Registration failed"
                println(_response.value)
                status = false
            }
        }
    }
}