package com.example.pokedek.model.remote.itemresponse.itemsumreponse


import com.google.gson.annotations.SerializedName

class LanguageX(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)