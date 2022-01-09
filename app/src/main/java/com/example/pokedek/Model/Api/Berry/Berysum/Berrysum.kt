package com.example.pokedek.Model.Api.Berry.Berysum


import com.google.gson.annotations.SerializedName

class Berrysum(
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