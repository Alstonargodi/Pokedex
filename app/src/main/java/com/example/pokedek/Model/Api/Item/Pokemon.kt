package com.example.pokedek.Model.Api.Item


import com.google.gson.annotations.SerializedName

class Pokemon(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)