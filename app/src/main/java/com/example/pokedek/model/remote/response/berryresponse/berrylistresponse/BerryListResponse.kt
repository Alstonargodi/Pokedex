package com.example.pokedek.model.remote.response.berryresponse.berrylistresponse


import com.google.gson.annotations.SerializedName

class BerryListResponse(
    @SerializedName("count")
    var count: Int,
    @SerializedName("next")
    var next: String,
    @SerializedName("previous")
    var previous: Any,
    @SerializedName("berryListResults")
    var berryListResults: List<BerryListResult>
)

class BerryListResult(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)