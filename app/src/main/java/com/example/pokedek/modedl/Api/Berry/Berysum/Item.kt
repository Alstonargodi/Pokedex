package com.example.pokedek.modedl.Api.Berry.Berysum


import com.google.gson.annotations.SerializedName

class Item(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)