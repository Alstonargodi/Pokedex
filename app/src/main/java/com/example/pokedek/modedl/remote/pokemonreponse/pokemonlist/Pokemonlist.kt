package com.example.pokedek.modedl.remote.pokemonreponse.pokemonlist


import com.google.gson.annotations.SerializedName

class Pokemonlist(
    @SerializedName("count")
    var count: Int,
    @SerializedName("next")
    var next: String,
    @SerializedName("previous")
    var previous: Any,
    @SerializedName("results")
    var results: List<Result>
)