package com.example.pokedek.modedl.Api.Pokemon.Pokemonsum


import com.google.gson.annotations.SerializedName

class Version(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)