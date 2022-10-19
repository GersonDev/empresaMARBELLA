package com.example.empresamarbella.domain.repositories

import com.example.empresamarbella.data.RemoteDataSource
import com.example.empresamarbella.domain.models.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UsuarioRepository {

    private val remoteDataSource = RemoteDataSource()

    suspend fun getUsers(): List<Usuario> {
        return withContext(Dispatchers.IO) {
            remoteDataSource.getUsersFromRemote()
        }
    }

    suspend fun postUser(id: Int, nombre: String, apellido: String, telefono: Int) {
        withContext(Dispatchers.IO) {
            remoteDataSource.sendUserFromRemote(
                id, nombre, apellido, telefono
            )
        }
    }
}