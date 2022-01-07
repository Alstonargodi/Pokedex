package com.example.pokedek.Model.Api.Pokeablity


import com.google.gson.annotations.SerializedName

class VersionGroup(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)