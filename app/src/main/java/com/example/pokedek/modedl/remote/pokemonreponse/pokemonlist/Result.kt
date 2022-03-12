package com.example.pokedek.modedl.remote.pokemonreponse.pokemonlist


import com.google.gson.annotations.SerializedName


class Result(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)