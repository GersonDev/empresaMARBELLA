package com.example.empresamarbella.ui.third

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.empresamarbella.domain.models.Usuario
import com.example.empresamarbella.domain.repositories.UsuarioRepository
import kotlinx.coroutines.launch

class ThirdViewModel(val app: Application) : AndroidViewModel(app) {

    private val usuarioRepository: UsuarioRepository = UsuarioRepository()

    private val _usuariosMutableLiveData = MutableLiveData<List<Usuario>>(emptyList())
    val usuariosMutableLiveData: LiveData<List<Usuario>> = _usuariosMutableLiveData

    fun traerListaDeUsers() {
        viewModelScope.launch {
            val usuarios = usuarioRepository.getUsers()
            _usuariosMutableLiveData.value = usuarios
        }
    }
}