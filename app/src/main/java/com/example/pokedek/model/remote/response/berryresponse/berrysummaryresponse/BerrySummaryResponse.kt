package com.example.pokedek.model.remote.response.berryresponse.berrysummaryresponse


import com.google.gson.annotations.SerializedName

class BerrySummaryResponse(
    @SerializedName("firmness")
    var firmness: Firmness,
    @SerializedName("flavors")
    var flavors: List<Flavor>,
    @SerializedName("growth_time")
    var growthTime: Int,
    @SerializedName("id")
    var id: Int,
    @SerializedName("item")
    var item: Item,
    @SerializedName("max_harvest")
    var maxHarvest: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("natural_gift_power")
    var naturalGiftPower: Int,
    @SerializedName("natural_gift_type")
    var naturalGiftType: NaturalGiftType,
    @SerializedName("size")
    var size: Int,
    @SerializedName("smoothness")
    var smoothness: Int,
    @SerializedName("soil_dryness")
    var soilDryness: Int
)

class Firmness(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

class Flavor(
    @SerializedName("flavor")
    var flavor: FlavorX,
    @SerializedName("potency")
    var potency: Int
)

class FlavorX(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

class Item(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

class NaturalGiftType(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)