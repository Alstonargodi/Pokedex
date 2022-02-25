package com.example.pokedek.modedl.Api.Item.Itemsumarry


import com.google.gson.annotations.SerializedName

class GameIndice(
    @SerializedName("game_index")
    var gameIndex: Int,
    @SerializedName("generation")
    var generation: Generation
)