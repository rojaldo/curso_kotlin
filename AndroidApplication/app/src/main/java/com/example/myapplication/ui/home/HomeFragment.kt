package com.example.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val textView: TextView get() = binding.textHome

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        textView.text = "Hola mundo!"
        val button: Button = binding.buttonChulo
        button.setOnClickListener {
            textView.text = "Has pulsado el botón!"
        }
        // homeViewModel.text.observe(viewLifecycleOwner) {
        //     textView.text = it
        // }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}