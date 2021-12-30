package com.example.pokedek.Model.Pokemonsum


import com.google.gson.annotations.SerializedName

class GenerationIi(
    @SerializedName("crystal")
    var crystal: Crystal,
    @SerializedName("gold")
    var gold: Gold,
    @SerializedName("silver")
    var silver: Silver
)