package com.example.pokedek.model.remote.response.pokemonreponse.Pokemonsum


import com.google.gson.annotations.SerializedName

class MoveX(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)