package com.example.pokedek.Model.Api.Pokemon.Pokemonsum


import com.google.gson.annotations.SerializedName

class DreamWorld(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any
)