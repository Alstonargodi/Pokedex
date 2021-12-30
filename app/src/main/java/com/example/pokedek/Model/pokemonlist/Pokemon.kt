package com.example.pokedek.Model.pokemonlist


import com.google.gson.annotations.SerializedName

class Pokemon(
    @SerializedName("count")
    var count: Int,
    @SerializedName("next")
    var next: String,
    @SerializedName("previous")
    var previous: Any,
    @SerializedName("results")
    var results: List<Result>
)