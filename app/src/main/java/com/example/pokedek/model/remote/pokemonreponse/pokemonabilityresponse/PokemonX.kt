package com.example.pokedek.model.remote.pokemonreponse.pokemonabilityresponse


import com.google.gson.annotations.SerializedName

class PokemonX(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)