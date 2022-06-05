package com.example.pokedek.model.remote.response.pokemonreponse.Pokemoves


import com.google.gson.annotations.SerializedName

class DamageClass(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)