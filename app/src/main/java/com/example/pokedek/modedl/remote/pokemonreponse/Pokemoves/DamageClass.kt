package com.example.pokedek.modedl.remote.pokemonreponse.Pokemoves


import com.google.gson.annotations.SerializedName

class DamageClass(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)