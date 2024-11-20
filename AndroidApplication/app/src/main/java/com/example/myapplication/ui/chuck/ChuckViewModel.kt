package com.example.myapplication.ui.chuck

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class ChuckViewModel : ViewModel() {

    private val apiService = RetrofitInstance.api

    val jokeData = liveData(Dispatchers.IO) {
        try {
            val response = apiService.getRandomJoke()
            emit(response)
        } catch (e: Exception) {
            emit(null)
        }
    }
}