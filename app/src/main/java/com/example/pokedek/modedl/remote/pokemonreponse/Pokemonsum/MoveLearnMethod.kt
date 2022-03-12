package com.example.pokedek.modedl.remote.pokemonreponse.Pokemonsum


import com.google.gson.annotations.SerializedName

class MoveLearnMethod(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)