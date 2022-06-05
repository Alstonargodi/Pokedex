package com.example.pokedek.model.remote.response.pokemonreponse.pokemonabilityresponse


import com.google.gson.annotations.SerializedName

class Pokemon(
    @SerializedName("is_hidden")
    var isHidden: Boolean,
    @SerializedName("pokemon")
    var pokemon: PokemonX,
    @SerializedName("slot")
    var slot: Int
)