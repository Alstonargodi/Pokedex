package com.example.pokedek.modedl.Api.Pokemon.Pokemonsum


import com.google.gson.annotations.SerializedName

class GameIndice(
    @SerializedName("game_index")
    var gameIndex: Int,
    @SerializedName("version")
    var version: Version
)