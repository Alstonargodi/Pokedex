package com.example.pokedek.modedl.Api.Item.Itemsumarry


import com.google.gson.annotations.SerializedName

class Name(
    @SerializedName("language")
    var language: LanguageXX,
    @SerializedName("name")
    var name: String
)