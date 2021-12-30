package com.example.pokedek.Model.Pokemonsum


import com.google.gson.annotations.SerializedName

class UltraSunUltraMoon(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any
)