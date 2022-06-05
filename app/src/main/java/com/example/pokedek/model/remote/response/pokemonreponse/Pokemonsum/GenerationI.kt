package com.example.pokedek.model.remote.response.pokemonreponse.Pokemonsum


import com.google.gson.annotations.SerializedName

class GenerationI(
    @SerializedName("red-blue")
    var redBlue: RedBlue,
    @SerializedName("yellow")
    var yellow: Yellow
)