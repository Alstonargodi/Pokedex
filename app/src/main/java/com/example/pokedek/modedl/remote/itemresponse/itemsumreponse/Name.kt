package com.example.pokedek.modedl.remote.itemresponse.itemsumreponse


import com.google.gson.annotations.SerializedName

class Name(
    @SerializedName("language")
    var language: LanguageXX,
    @SerializedName("name")
    var name: String
)