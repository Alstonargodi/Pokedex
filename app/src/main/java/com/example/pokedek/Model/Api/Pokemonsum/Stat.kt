package com.example.pokedek.Model.Api.Pokemonsum


import com.google.gson.annotations.SerializedName

class Stat(
    @SerializedName("base_stat")
    var baseStat: Int,
    @SerializedName("effort")
    var effort: Int,
    @SerializedName("stat")
    var stat: StatX
)