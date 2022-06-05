package com.example.pokedek.model.remote.response.itemresponse.itemsummaryresponse


import com.google.gson.annotations.SerializedName

class ItemSummaryResponse(
    @SerializedName("attributes")
    var attributes: List<Attribute>,
    @SerializedName("baby_trigger_for")
    var babyTriggerFor: Any,
    @SerializedName("category")
    var category: Category,
    @SerializedName("cost")
    var cost: Int,
    @SerializedName("effect_entries")
    var effectEntries: List<EffectEntry>,
    @SerializedName("flavor_text_entries")
    var flavorTextEntries: List<FlavorTextEntry>,
    @SerializedName("fling_effect")
    var flingEffect: FlingEffect,
    @SerializedName("fling_power")
    var flingPower: Int,
    @SerializedName("game_indices")
    var gameIndices: List<GameIndice>,
    @SerializedName("held_by_pokemon")
    var heldByPokemon: List<HeldByPokemon>,
    @SerializedName("id")
    var id: Int,
    @SerializedName("machines")
    var machines: List<Any>,
    @SerializedName("name")
    var name: String,
    @SerializedName("names")
    var names: List<Name>,
    @SerializedName("sprites")
    var sprites: Sprites
)

class Attribute(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

class Category(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

class EffectEntry(
    @SerializedName("effect")
    var effect: String,
    @SerializedName("language")
    var language: Language,
    @SerializedName("short_effect")
    var shortEffect: String
)

class FlavorTextEntry(
    @SerializedName("text")
    var text: String,
    @SerializedName("version_group")
    var versionGroup: VersionGroup
)

class FlingEffect(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

class GameIndice(
    @SerializedName("game_index")
    var gameIndex: Int,
    @SerializedName("generation")
    var generation: Generation
)

class Generation(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

class HeldByPokemon(
    @SerializedName("pokemon")
    var pokemon: Pokemon,
    @SerializedName("version_details")
    var versionDetails: List<VersionDetail>
)
class Language(
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
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

class Sprites(
    @SerializedName("default")
    var default: String
)

class Version(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

class VersionDetail(
    @SerializedName("rarity")
    var rarity: Int,
    @SerializedName("version")
    var version: Version
)

class VersionGroup(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)