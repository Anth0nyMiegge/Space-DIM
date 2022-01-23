package com.example.spacedim

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/* Définition des "constantes" : lien de l'API, parser Moshi, instance de Retrofit pour l'utiliser */
const val baseLink = "https://spacedim.async-agency.com/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(baseLink)
    .build()

/* Implémentation du Service permettant de définir toutes les fonctions, leurs paramètres et le type de sortie */
interface UsersApiService {
    /* Get all users */
    @GET("api/users")
    suspend fun getUsers(): List<User>
    /* Get a user by its name */
    @GET("api/find/user/{name}")
    suspend fun getUserByName(name: String): User
    /* Get a user by its ID */
    @GET("api/user/{id}")
    suspend fun getUserById(id: Int): User
    /* Register a user (takes a UserPost (only a name)) */
    @POST("api/user/register")
    suspend fun registerNewUser(@Body userPost: UserPost): Response<UserPost>
}

/* Démarrage (en lazy, pour les performances) de Retrofit afin de faire des appels API */
object UsersApi {
    val retrofitService : UsersApiService by lazy {
        retrofit.create(UsersApiService::class.java) }
}

/* Définition du ViewModel, seule classe accessible par les autres fichiers */
class OverviewViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    /* Le statut servant à indiquer si la requette a réussi, permettant ainsi d'exécuter une autre action en fonction */
    var status: Boolean = false

    /* Fonction inutile pour l'instant, mais définie pour coller avec le Service */
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

    /* Fonction permettant de récupérer l'utilisateur par son nom, nottament si le register détecte que l'utilisateur existe déjà */
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

    /* Fonction inutile pour l'instant, mais définie pour coller avec le Service */
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

    /* Fonction permettant de register l'utilisateur s'il est inexistant, sinon, lance getUserByName() */
    fun registerNewUser(userPost: UserPost) {
        viewModelScope.launch {
            try {
                val result = UsersApi.retrofitService.registerNewUser(userPost)
                _response.value = "Successfuly registered"
                println(_response.value)
                status = true
            } catch (e: Exception) {
                _response.value = "Registration failed : User already exists"
                println(_response.value)
                status = false
            }
        }
        if (!status) {
            viewModelScope.launch {
                try {
                    UsersApi.retrofitService.getUserByName(userPost.name)
                } catch (e: Exception) {
                    println("Unknown error : ${e.message}")
                }
            }
        }
    }
}