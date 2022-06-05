package com.example.pokedek.model.remote.response.pokemonreponse.pokemonabilityresponse


import com.google.gson.annotations.SerializedName

class Generation(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)