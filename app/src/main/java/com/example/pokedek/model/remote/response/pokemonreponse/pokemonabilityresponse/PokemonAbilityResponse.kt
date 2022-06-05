package com.example.pokedek.model.remote.response.pokemonreponse.pokemonabilityresponse


import com.google.gson.annotations.SerializedName

class PokemonAbilityResponse(
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

class EffectEntry(
    @SerializedName("effect")
    var effect: String,
    @SerializedName("short_effect")
    var shortEffect: String
)

class FlavorTextEntry(
    @SerializedName("flavor_text")
    var flavorText: String,
    @SerializedName("version_group")
    var versionGroup: VersionGroup
)
class Generation(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

class Name(
    @SerializedName("name")
    var name: String
)

class Pokemon(
    @SerializedName("is_hidden")
    var isHidden: Boolean,
    @SerializedName("pokemon")
    var pokemon: PokemonX,
    @SerializedName("slot")
    var slot: Int
)

class PokemonX(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

class VersionGroup(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)