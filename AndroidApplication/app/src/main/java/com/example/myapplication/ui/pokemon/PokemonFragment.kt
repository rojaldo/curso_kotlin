package com.example.myapplication.ui.pokemon

import Pokemon
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
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPokemonBinding
import com.example.myapplication.models.PokemonInfo
import com.example.myapplication.models.PokemonInfoResponse
import com.squareup.picasso.Picasso
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PokemonFragment : Fragment() {

    private lateinit var randomPokemon: PokemonInfo
    private var _binding: FragmentPokemonBinding? = null
    private val viewModel: PokemonViewModel by  activityViewModels()

    private lateinit var pokemonList: List<PokemonInfo>

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

            // get 3 random pokemon from the list different from the current pokemon
            val randomPokemonList = pokemonList.filter { it.name != randomPokemon.name }.shuffled().take(3)
            Log.d("PokemonFragment", "Random pokemon list: ${randomPokemonList.map { it.name }}")
            binding.button1.text = randomPokemonList[0].name
            binding.button2.text = randomPokemonList[1].name
            binding.button3.text = randomPokemonList[2].name
            binding.button4.text = randomPokemon.name
        })

        viewModel.pokemonList.observe(viewLifecycleOwner, Observer {
            Log.d("PokemonFragment", "Pokemon list updated")
            // convert pokemoninforesponse list to pokemoninfo list
            pokemonList = it.map { pokemonInfoResponse ->
                PokemonInfo(
                    name = pokemonInfoResponse.name,
                    url = pokemonInfoResponse.url,
                    id = pokemonInfoResponse.url.split("/").filter { it.isNotEmpty() }.last().toInt()
                )
            }
            Log.d("PokemonFragment", "Pokemon list size: ${pokemonList.size}")
            // get a random pokemon from the list
            randomPokemon = pokemonList.random()
            Log.d("PokemonFragment", "Random pokemon: ${randomPokemon.name}")
            viewModel.getPokemon(randomPokemon.id)



        })

        val navController = findNavController()

        binding.button1.setOnClickListener {
            Log.d("PokemonFragment", "Button 1 clicked")
            navController.navigate(R.id.nav_pokemon_result)
            // set selected pokemon name
            viewModel.setSelectedPokemonName(binding.button1.text.toString())

        }

        binding.button2.setOnClickListener {
            Log.d("PokemonFragment", "Button 2 clicked")
            navController.navigate(R.id.nav_pokemon_result)
            viewModel.setSelectedPokemonName(binding.button2.text.toString())


        }

        binding.button3.setOnClickListener {
            Log.d("PokemonFragment", "Button 3 clicked")
            viewLifecycleOwner.lifecycleScope.launch {
                delay(1000)
                navController.navigate(R.id.nav_pokemon_result)
                viewModel.setSelectedPokemonName(binding.button3.text.toString())
            }
        }

        binding.button4.setOnClickListener {
            Log.d("PokemonFragment", "Button 4 clicked")
            navController.navigate(R.id.nav_pokemon_result)
            viewModel.setSelectedPokemonName(binding.button4.text.toString())
        }
        
        return root
    }

    override fun onResume() {
        super.onResume()
        // if current fragment is  PokemonResultFragment, navigate to PokemonFragment

        val navController = findNavController()

        if (findNavController().currentDestination?.id == R.id.nav_pokemon_result) {
            findNavController().navigateUp()
        }
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
