package com.example.pokedek.model.remote.itemresponse.itemsumreponse


import com.google.gson.annotations.SerializedName

class VersionDetail(
    @SerializedName("rarity")
    var rarity: Int,
    @SerializedName("version")
    var version: Version
)