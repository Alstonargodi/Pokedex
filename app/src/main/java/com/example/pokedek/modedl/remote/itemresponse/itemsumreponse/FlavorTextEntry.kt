package com.example.pokedek.modedl.remote.itemresponse.itemsumreponse


import com.google.gson.annotations.SerializedName

class FlavorTextEntry(
    @SerializedName("language")
    var language: LanguageX,
    @SerializedName("text")
    var text: String,
    @SerializedName("version_group")
    var versionGroup: VersionGroup
)