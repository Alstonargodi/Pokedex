package com.example.pokedek.Model.Pokemonsum


import com.google.gson.annotations.SerializedName

class Emerald(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_shiny")
    var frontShiny: String
)