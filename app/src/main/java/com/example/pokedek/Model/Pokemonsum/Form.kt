package com.example.pokedek.Model.Pokemonsum


import com.google.gson.annotations.SerializedName

class Form(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)