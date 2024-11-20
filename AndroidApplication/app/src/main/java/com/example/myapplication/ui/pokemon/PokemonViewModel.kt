package com.example.myapplication.ui.chuck

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

    init {
        getPokemon(1)
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
            val pokemons: PokemonListResponse = apiService.getAllPokemon()
        }
    }
    


}