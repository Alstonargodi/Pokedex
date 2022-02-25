package com.example.pokedek.modedl.Api.Pokemon.Pokemonsum


import com.google.gson.annotations.SerializedName

class DiamondPearl(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_female")
    var backFemale: Any,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("back_shiny_female")
    var backShinyFemale: Any,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any
)