package com.example.pokedek.modedl.remote.itemresponse.itemsumreponse


import com.google.gson.annotations.SerializedName

class Category(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)