package com.example.empresamarbella

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.empresamarbella.databinding.UsuariosCeldasBinding
import com.example.empresamarbella.domain.models.Usuario

class UsuarioAdapter(val usuarios: MutableList<Usuario> = mutableListOf()) :
    RecyclerView.Adapter<UsuarioAdapter.ViewHolder>() {
    class ViewHolder(val itemBinding: UsuariosCeldasBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(usario: Usuario) {
            itemBinding.codigoUsuarioTextView.text = usario.id.toString()
            itemBinding.nombreTextView.text = usario.nombre.toString()
            itemBinding.apellidoTextView.text = usario.apellido.toString()
            itemBinding.telefonoTextView.text = usario.telefono.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            UsuariosCeldasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(usuarios.get(position))
    }

    override fun getItemCount(): Int {
        return usuarios.size
    }
    fun agregarUsuarios(listaDeUsuarios: List<Usuario>){
        usuarios.addAll(listaDeUsuarios)
        notifyDataSetChanged()
    }
    fun agregarUsuario(usuario: Usuario){
        usuarios.add(usuario)
        notifyDataSetChanged()
    }
}