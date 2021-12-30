package com.example.pokedek.Model.pokemonlist


import com.google.gson.annotations.SerializedName

class Result(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)