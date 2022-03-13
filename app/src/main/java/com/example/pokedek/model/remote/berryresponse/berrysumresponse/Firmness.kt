package com.example.pokedek.model.remote.berryresponse.berrysumresponse


import com.google.gson.annotations.SerializedName

class Firmness(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)