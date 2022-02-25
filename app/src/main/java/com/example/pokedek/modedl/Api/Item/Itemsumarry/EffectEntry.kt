package com.example.pokedek.modedl.Api.Item.Itemsumarry


import com.google.gson.annotations.SerializedName

class EffectEntry(
    @SerializedName("effect")
    var effect: String,
    @SerializedName("language")
    var language: Language,
    @SerializedName("short_effect")
    var shortEffect: String
)