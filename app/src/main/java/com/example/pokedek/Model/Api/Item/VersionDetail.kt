package com.example.pokedek.Model.Api.Item


import com.google.gson.annotations.SerializedName

class VersionDetail(
    @SerializedName("rarity")
    var rarity: Int,
    @SerializedName("version")
    var version: Version
)