package com.example.pokedek.model.remote.pokemonreponse.Pokemonsum


import com.google.gson.annotations.SerializedName

class TypeX(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)