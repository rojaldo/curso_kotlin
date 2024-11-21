package com.example.myapplication.ui.pokemon

import ChuckNorrisJoke
import Pokemon
import PokemonResponse
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.models.PokemonInfoResponse
import com.example.myapplication.models.PokemonListResponse
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    private val apiService = RetrofitPokemonInstance.api

    private val _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon> get() = _pokemon

    private val _pokemonList = MutableLiveData<List<PokemonInfoResponse>>()
    val pokemonList: LiveData<List<PokemonInfoResponse>> get() = _pokemonList

    private val _selectedPokemonName = MutableLiveData<String>()
    val selectedPokemonName: LiveData<String> get() = _selectedPokemonName

    init {
        //getPokemon(1)
        getAllPokemon()
    }

    // this method updates the value of the joke live data does not have suspend modifier
    fun getPokemon(id: Int) {
        viewModelScope.launch {
            val pokemon: PokemonResponse = apiService.getPokemon(id)
            _pokemon.value = Pokemon(
                name = pokemon.name,
                id = pokemon.id,
                sprites = pokemon.sprites
            )
        }
    }

    fun getAllPokemon() {
        viewModelScope.launch {
            val pokemonList: PokemonListResponse = apiService.getAllPokemon()
            _pokemonList.value = pokemonList.results
        }
    }

    fun setSelectedPokemonName(name: String) {
        _selectedPokemonName.value = name
    }
    


}