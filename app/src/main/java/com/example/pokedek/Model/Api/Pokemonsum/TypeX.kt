package com.example.pokedek.Model.Api.Pokemonsum


import com.google.gson.annotations.SerializedName

class TypeX(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)