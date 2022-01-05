package com.example.pokedek.Model.Api.Pokemonsum


import com.google.gson.annotations.SerializedName

class Icons(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any
)