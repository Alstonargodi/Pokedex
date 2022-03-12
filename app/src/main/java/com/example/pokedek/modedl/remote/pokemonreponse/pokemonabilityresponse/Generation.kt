package com.example.pokedek.modedl.remote.pokemonreponse.pokemonabilityresponse


import com.google.gson.annotations.SerializedName

class Generation(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)