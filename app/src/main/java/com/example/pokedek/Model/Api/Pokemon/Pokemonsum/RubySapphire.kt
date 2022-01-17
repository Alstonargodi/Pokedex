package com.example.pokedek.Model.Api.Pokemon.Pokemonsum


import com.google.gson.annotations.SerializedName

class RubySapphire(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_shiny")
    var frontShiny: String
)