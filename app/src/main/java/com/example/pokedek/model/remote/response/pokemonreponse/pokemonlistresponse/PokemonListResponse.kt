package com.example.pokedek.model.remote.response.pokemonreponse.pokemonlistresponse


import com.google.gson.annotations.SerializedName

class Pokemonlist(
    @SerializedName("count")
    var count: Int,
    @SerializedName("next")
    var next: String,
    @SerializedName("previous")
    var previous: Any,
    @SerializedName("results")
    var results: List<PokemonListResult>
)

class PokemonListResult(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)