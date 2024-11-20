package com.example.myapplication.ui.chuck

import ChuckNorrisJoke
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ChuckViewModel : ViewModel() {

    private val apiService = RetrofitInstance.api
    private val _joke = MutableLiveData<ChuckNorrisJoke>()
    val joke: LiveData<ChuckNorrisJoke> get() = _joke

    init {
        getNewJoke()
    }

    // this method updates the value of the joke live data does not have suspend modifier
    fun getNewJoke() {
        viewModelScope.launch {
            val joke: ChuckNorrisJoke = apiService.getRandomJoke()
            _joke.value = joke
        }
    }
    


}