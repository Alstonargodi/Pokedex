package com.example.pokedek.model.remote.response.pokemonreponse.Pokemoves


import com.google.gson.annotations.SerializedName

class Name(
    @SerializedName("language")
    var language: LanguageXX,
    @SerializedName("name")
    var name: String
)