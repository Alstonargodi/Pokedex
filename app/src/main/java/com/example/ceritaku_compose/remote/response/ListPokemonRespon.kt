package com.example.ceritaku_compose.remote.response

import com.google.gson.annotations.SerializedName

class ListPokemonRespon(
    @SerializedName("count")
    var count: Int,
    @SerializedName("next")
    var next: String,
    @SerializedName("previous")
    var previous: Any,
    @SerializedName("results")
    var results: List<PokemonListResult>,
)

class PokemonListResult(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String,
)