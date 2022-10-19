package com.example.empresamarbella.ui.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.empresamarbella.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    val secondViewModel: SecondViewModel by viewModels()

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.guardarButton.setOnClickListener {
            val id = binding.codigoUsuarioEditText.text.toString().toInt()
            val nombre = binding.nombreEdixText.text.toString()
            val apellido = binding.apellidoEditText.text.toString()
            val telefono = binding.telefonoEditText.text.toString().toInt()

            secondViewModel.registrarDatos(
                id, nombre, apellido, telefono
            )

            secondViewModel.confirmacionMutableLiveData.observe(viewLifecycleOwner, Observer {
                Toast.makeText(requireContext(), "Se inserto Correctamente", Toast.LENGTH_SHORT)
                    .show()
            })


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}