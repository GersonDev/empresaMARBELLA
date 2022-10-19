package com.example.empresamarbella.ui.second

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.empresamarbella.domain.models.Usuario
import com.example.empresamarbella.domain.repositories.UsuarioRepository
import kotlinx.coroutines.launch

class SecondViewModel(val app: Application) : AndroidViewModel(app) {

    private val usuarioRepository: UsuarioRepository = UsuarioRepository()

    private val _confirmacionMutableLiveData = MutableLiveData<Boolean>(false)
    val confirmacionMutableLiveData: LiveData<Boolean> = _confirmacionMutableLiveData

    fun registrarDatos(id: Int, nombre: String, apellido: String, telefono: Int) {
        viewModelScope.launch {
            usuarioRepository.postUser(
                id, nombre, apellido, telefono
            )
            _confirmacionMutableLiveData.value = true
        }
    }
}