package com.example.pokedek.model.remote.pokemonreponse.pokemonabilityresponse


import com.google.gson.annotations.SerializedName

class Pokeablty(
    @SerializedName("effect_changes")
    var effectChanges: List<Any>,
    @SerializedName("effect_entries")
    var effectEntries: List<EffectEntry>,
    @SerializedName("flavor_text_entries")
    var flavorTextEntries: List<FlavorTextEntry>,
    @SerializedName("generation")
    var generation: Generation,
    @SerializedName("id")
    var id: Int,
    @SerializedName("is_main_series")
    var isMainSeries: Boolean,
    @SerializedName("name")
    var name: String,
    @SerializedName("names")
    var names: List<Name>,
    @SerializedName("pokemon")
    var pokemon: List<Pokemon>
)