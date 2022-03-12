package com.example.pokedek.modedl.remote.itemresponse.itemsumreponse


import com.google.gson.annotations.SerializedName

class VersionDetail(
    @SerializedName("rarity")
    var rarity: Int,
    @SerializedName("version")
    var version: Version
)