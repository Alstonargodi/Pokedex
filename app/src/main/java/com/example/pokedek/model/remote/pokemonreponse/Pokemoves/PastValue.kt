package com.example.pokedek.model.remote.pokemonreponse.Pokemoves


import com.google.gson.annotations.SerializedName

class PastValue(
    @SerializedName("accuracy")
    var accuracy: Int,
    @SerializedName("effect_chance")
    var effectChance: Any,
    @SerializedName("effect_entries")
    var effectEntries: List<Any>,
    @SerializedName("power")
    var power: Any,
    @SerializedName("pp")
    var pp: Any,
    @SerializedName("type")
    var type: Any,
    @SerializedName("version_group")
    var versionGroup: VersionGroupXX
)