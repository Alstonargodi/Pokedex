package com.example.pokedek.model.remote.itemresponse.itemsumreponse


import com.google.gson.annotations.SerializedName

class GameIndice(
    @SerializedName("game_index")
    var gameIndex: Int,
    @SerializedName("generation")
    var generation: Generation
)