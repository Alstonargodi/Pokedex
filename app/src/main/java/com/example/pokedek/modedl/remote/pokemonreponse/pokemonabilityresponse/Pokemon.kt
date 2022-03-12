package com.example.pokedek.modedl.remote.pokemonreponse.pokemonabilityresponse


import com.google.gson.annotations.SerializedName

class Pokemon(
    @SerializedName("is_hidden")
    var isHidden: Boolean,
    @SerializedName("pokemon")
    var pokemon: PokemonX,
    @SerializedName("slot")
    var slot: Int
)