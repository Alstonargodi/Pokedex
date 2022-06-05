package com.example.pokedek.model.remote.response.pokemonreponse.Pokemonsum


import com.google.gson.annotations.SerializedName

class Icons(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any
)