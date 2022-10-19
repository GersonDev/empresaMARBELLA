package com.example.empresamarbella.data.api

import com.example.empresamarbella.data.api.requests.PostUserRequest
import com.example.empresamarbella.data.api.responses.GetUserReponse
import com.example.empresamarbella.data.api.responses.PostUserReponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface UsuarioApi {
    @GET("Usuarios/Usuarios")
    suspend fun getUsers(): List<GetUserReponse>

    @POST("Usuarios/Usuarios")
    suspend fun createUser(
        @Body postUserRequest: PostUserRequest
    ): PostUserReponse

}