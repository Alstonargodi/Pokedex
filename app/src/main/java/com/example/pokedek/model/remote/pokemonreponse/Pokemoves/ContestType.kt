package com.example.pokedek.model.remote.pokemonreponse.Pokemoves


import com.google.gson.annotations.SerializedName

class ContestType(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)