package com.example.pokedek.Model.Api.Pokemon.Pokeablity


import com.google.gson.annotations.SerializedName

class Generation(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)