package com.example.empresamarbella.ui.third

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.empresamarbella.R
import com.example.empresamarbella.UsuarioAdapter
import com.example.empresamarbella.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    val thirdViewModel: ThirdViewModel by viewModels()
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    private val usuarioAdapter = UsuarioAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarRecyclerView()

        thirdViewModel.traerListaDeUsers()
        thirdViewModel.usuariosMutableLiveData.observe(viewLifecycleOwner, Observer {
            usuarioAdapter.agregarUsuarios(
                it
            )
        })
    }

    private fun configurarRecyclerView() {
        binding.recyclerView.adapter = usuarioAdapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }


}