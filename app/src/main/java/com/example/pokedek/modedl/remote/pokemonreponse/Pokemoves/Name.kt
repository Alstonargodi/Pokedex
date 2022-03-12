package com.example.pokedek.modedl.remote.pokemonreponse.Pokemoves


import com.google.gson.annotations.SerializedName

class Name(
    @SerializedName("language")
    var language: LanguageXX,
    @SerializedName("name")
    var name: String
)