package com.example.myapplication.models

data class PokemonInfoResponse(
    val name: String,
    val url: String
)

data class PokemonInfo(
    val name: String,
    val url: String,
    val id: Int,
)

data class PokemonListResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<PokemonInfoResponse>
)