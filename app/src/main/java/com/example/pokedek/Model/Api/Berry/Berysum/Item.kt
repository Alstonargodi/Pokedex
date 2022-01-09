package com.example.pokedek.Model.Api.Berry.Berysum


import com.google.gson.annotations.SerializedName

class Item(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)