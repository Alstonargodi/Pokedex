package com.example.pokedek.Model.Api.Pokemon.Pokemoves


import com.google.gson.annotations.SerializedName

class Meta(
    @SerializedName("ailment")
    var ailment: Ailment,
    @SerializedName("ailment_chance")
    var ailmentChance: Int,
    @SerializedName("category")
    var category: Category,
    @SerializedName("crit_rate")
    var critRate: Int,
    @SerializedName("drain")
    var drain: Int,
    @SerializedName("flinch_chance")
    var flinchChance: Int,
    @SerializedName("healing")
    var healing: Int,
    @SerializedName("max_hits")
    var maxHits: Any,
    @SerializedName("max_turns")
    var maxTurns: Any,
    @SerializedName("min_hits")
    var minHits: Any,
    @SerializedName("min_turns")
    var minTurns: Any,
    @SerializedName("stat_chance")
    var statChance: Int
)