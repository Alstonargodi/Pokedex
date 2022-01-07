package com.example.pokedek.Model.Api.Pokeablity


import com.google.gson.annotations.SerializedName

class FlavorTextEntry(
    @SerializedName("flavor_text")
    var flavorText: String,
    @SerializedName("language")
    var language: LanguageX,
    @SerializedName("version_group")
    var versionGroup: VersionGroup
)