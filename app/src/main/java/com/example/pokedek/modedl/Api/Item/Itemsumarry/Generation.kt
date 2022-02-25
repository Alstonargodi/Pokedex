package com.example.pokedek.modedl.Api.Item.Itemsumarry


import com.google.gson.annotations.SerializedName

class Generation(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)