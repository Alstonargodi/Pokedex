package com.example.pokedek.Model.Api.Pokemonsum


import com.google.gson.annotations.SerializedName

class Species(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)