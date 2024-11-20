package com.example.myapplication.ui.chuck

import ChuckNorrisJoke
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentChuckBinding
import com.example.myapplication.databinding.FragmentHelloBinding

class ChuckFragment : Fragment() {

    private var _binding: FragmentChuckBinding? = null
    private val viewModel: ChuckViewModel by  activityViewModels()


//    private val textView: TextView get() = binding.textHome

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val chuckViewModel =
            ViewModelProvider(this).get(ChuckViewModel::class.java)

        _binding = FragmentChuckBinding.inflate(inflater, container, false)
        val root: View = binding.root


        Log.d("ChuckFragment", "onCreateView: ")
        viewModel.joke.observe(viewLifecycleOwner, Observer {
//            cast it to cucknorrisjoke
//            val joke = it as ChuckNorrisJoke
            binding.jokeTextView.text = it.value
        })
        
        binding.anotherJokeButton.setOnClickListener {
            //load another joke
            viewModel.getNewJoke()
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}