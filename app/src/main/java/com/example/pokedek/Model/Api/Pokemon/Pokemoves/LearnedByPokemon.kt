package com.example.pokedek.Model.Api.Pokemon.Pokemoves


import com.google.gson.annotations.SerializedName

class LearnedByPokemon(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)