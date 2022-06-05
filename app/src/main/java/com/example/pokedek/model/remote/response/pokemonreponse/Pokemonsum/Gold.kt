package com.example.pokedek.model.remote.response.pokemonreponse.Pokemonsum


import com.google.gson.annotations.SerializedName

class Gold(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_transparent")
    var frontTransparent: String
)