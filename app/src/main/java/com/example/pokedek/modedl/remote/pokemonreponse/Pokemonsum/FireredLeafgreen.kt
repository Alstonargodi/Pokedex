package com.example.pokedek.modedl.remote.pokemonreponse.Pokemonsum


import com.google.gson.annotations.SerializedName

class FireredLeafgreen(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_shiny")
    var frontShiny: String
)