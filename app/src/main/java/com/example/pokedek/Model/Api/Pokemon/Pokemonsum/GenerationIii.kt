package com.example.pokedek.Model.Api.Pokemon.Pokemonsum


import com.google.gson.annotations.SerializedName

class GenerationIii(
    @SerializedName("emerald")
    var emerald: Emerald,
    @SerializedName("firered-leafgreen")
    var fireredLeafgreen: FireredLeafgreen,
    @SerializedName("ruby-sapphire")
    var rubySapphire: RubySapphire
)