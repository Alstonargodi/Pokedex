package com.example.pokedek.Model.Api.Item


import com.google.gson.annotations.SerializedName

class FlingEffect(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)