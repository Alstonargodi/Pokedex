package com.example.pokedek.model.remote.response.pokemonreponse.Pokemonsum


import com.google.gson.annotations.SerializedName

class Stat(
    @SerializedName("base_stat")
    var baseStat: Int,
    @SerializedName("effort")
    var effort: Int,
    @SerializedName("stat")
    var stat: StatX
)