package com.example.pokedek.model.remote.berryresponse.berrylistresponse


import com.google.gson.annotations.SerializedName

class BerryListResponse(
    @SerializedName("count")
    var count: Int,
    @SerializedName("next")
    var next: String,
    @SerializedName("previous")
    var previous: Any,
    @SerializedName("results")
    var results: List<Result>
)