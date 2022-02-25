package com.example.pokedek.modedl.Api.Berry.BerryList


import com.google.gson.annotations.SerializedName

class Berrylist(
    @SerializedName("count")
    var count: Int,
    @SerializedName("next")
    var next: String,
    @SerializedName("previous")
    var previous: Any,
    @SerializedName("results")
    var results: List<Result>
)