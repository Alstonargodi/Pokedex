package com.example.pokedek.modedl.Api.Pokemon.Pokemonsum


import com.google.gson.annotations.SerializedName

class Stat(
    @SerializedName("base_stat")
    var baseStat: Int,
    @SerializedName("effort")
    var effort: Int,
    @SerializedName("stat")
    var stat: StatX
)