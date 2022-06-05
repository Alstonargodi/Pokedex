package com.example.pokedek.model.remote.response.pokemonreponse.pokemonlist


import com.google.gson.annotations.SerializedName

class Pokemonlist(
    @SerializedName("count")
    var count: Int,
    @SerializedName("next")
    var next: String,
    @SerializedName("previous")
    var previous: Any,
    @SerializedName("berryListResults")
    var results: List<Result>
)