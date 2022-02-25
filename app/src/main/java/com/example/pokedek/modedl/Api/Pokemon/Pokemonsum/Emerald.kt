package com.example.pokedek.modedl.Api.Pokemon.Pokemonsum


import com.google.gson.annotations.SerializedName

class Emerald(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_shiny")
    var frontShiny: String
)