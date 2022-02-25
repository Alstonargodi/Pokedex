package com.example.pokedek.modedl.Api.Pokemon.Pokemoves


import com.google.gson.annotations.SerializedName

class Language(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)