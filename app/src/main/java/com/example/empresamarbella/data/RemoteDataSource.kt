package com.example.empresamarbella.data

import com.example.empresamarbella.data.api.ApiClient
import com.example.empresamarbella.data.api.requests.PostUserRequest
import com.example.empresamarbella.domain.models.Usuario

class RemoteDataSource {

    suspend fun getUsersFromRemote(): List<Usuario> {
        val usersResponse = ApiClient.getClient().getUsers()
        val usuarios = usersResponse.map {
            Usuario(
                id = it.id,
                nombre = it.nombre,
                apellido = it.apellido,
                telefono = it.telefono,
            )
        }
        return usuarios
    }

    suspend fun sendUserFromRemote(id: Int, nombre: String, apellido: String, telefono: Int) {
        ApiClient.getClient().createUser(
            PostUserRequest(
                id = id,
                nombre = nombre,
                apellido = apellido,
                telefono = telefono
            )
        )
    }
}