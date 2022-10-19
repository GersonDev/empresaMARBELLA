package com.example.empresamarbella.data.api.requests

data class PostUserRequest(
    val id: Int,
    val nombre: String,
    val apellido: String,
    val telefono: Int
)
