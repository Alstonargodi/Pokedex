package com.example.pokedek.Model.Api.Pokemon.Pokeablity


import com.google.gson.annotations.SerializedName

class Pokemon(
    @SerializedName("is_hidden")
    var isHidden: Boolean,
    @SerializedName("pokemon")
    var pokemon: PokemonX,
    @SerializedName("slot")
    var slot: Int
)