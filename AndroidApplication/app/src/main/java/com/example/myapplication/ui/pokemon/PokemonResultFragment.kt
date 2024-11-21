package com.example.myapplication.ui.pokemon

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPokemonBinding
import com.example.myapplication.databinding.FragmentPokemonResultBinding
import com.squareup.picasso.Picasso

class PokemonResultFragment : Fragment() {

    private var _binding: FragmentPokemonResultBinding? = null
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

        _binding = FragmentPokemonResultBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setHasOptionsMenu(true) // Habilita el menú de opciones en el Fragment

        Log.d("PokemonFragment", "onCreateView: ")
        viewModel.pokemon.observe(viewLifecycleOwner, Observer {
            binding.pokemonName.text = it.name
            // set binding.pokemonName invisible
            // binding.pokemonName.visibility = View.INVISIBLE
            Picasso.get().load(it.sprites.other.home.front_default).into(binding.pokemonImage);
            // if selectedPokemonName is not null, check if it is the same as the current pokemon
            if (viewModel.selectedPokemonName.value != null) {
                if (viewModel.selectedPokemonName.value == it.name) {
                    // if it is the same, set the selectedPokemonName to null
                    binding.resultMessage.text = "Correcto!!"

                }else {
                    // if it is not the same, set the selectedPokemonName to null
                    binding.resultMessage.text = "Incorrecto"
            }
        }
        })

        binding.buttonNext.setOnClickListener {
            //go to pokemon fragment
            findNavController().navigate(R.id.action_pokemonResultFragment_to_pokemonFragment)
        }

        // Llama a fetchPokemon con el ID del Pokémon que deseas obtener
        //viewModel.getPokemon(1)

        val navController = findNavController()

        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.activity_main_drawer, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                val drawerLayout = activity?.findViewById<DrawerLayout>(R.id.drawer_layout)
                drawerLayout?.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
