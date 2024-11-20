package com.example.myapplication.ui.pokemon

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.FragmentChuckBinding
import com.example.myapplication.databinding.FragmentPokemonBinding
import com.example.myapplication.ui.chuck.PokemonViewModel
import com.squareup.picasso.Picasso

class PokemonFragment : Fragment() {

    private var _binding: FragmentPokemonBinding? = null
    private val viewModel: PokemonViewModel by  activityViewModels()

//    private val textView: TextView get() = binding.textHome

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPokemonBinding.inflate(inflater, container, false)
        val root: View = binding.root


        Log.d("PokemonFragment", "onCreateView: ")
        viewModel.pokemon.observe(viewLifecycleOwner, Observer {
            binding.pokemonName.text = it.name
            // set binding.pokemonName invisible
            binding.pokemonName.visibility = View.INVISIBLE
            Picasso.get().load(it.sprites.other.home.front_default).into(binding.pokemonImage);
        })

        // Llama a fetchPokemon con el ID del Pokémon que deseas obtener
        //viewModel.getPokemon(1)
        
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}