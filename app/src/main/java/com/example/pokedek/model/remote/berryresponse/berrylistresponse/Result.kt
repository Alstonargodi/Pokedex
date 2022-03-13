package com.example.pokedek.model.remote.berryresponse.berrylistresponse


import com.google.gson.annotations.SerializedName

class Result(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)