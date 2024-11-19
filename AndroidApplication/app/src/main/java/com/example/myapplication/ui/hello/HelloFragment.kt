package com.example.myapplication.ui.hello

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentHelloBinding
import com.example.myapplication.databinding.FragmentHomeBinding

class HelloFragment : Fragment() {

    private var _binding: FragmentHelloBinding? = null

//    private val textView: TextView get() = binding.textHome

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val helloViewModel =
            ViewModelProvider(this).get(HelloViewModel::class.java)

        _binding = FragmentHelloBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val editText: TextView = binding.editText
        val button: Button = binding.button
        val textView: TextView = binding.textView

        button.setOnClickListener {
            textView.text = "Hola, ${editText.text}!"
        }

//        textView.text = "Hola mundo!
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