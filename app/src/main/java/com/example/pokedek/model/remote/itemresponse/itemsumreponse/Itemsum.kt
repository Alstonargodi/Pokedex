package com.example.pokedek.model.remote.itemresponse.itemsumreponse


import com.google.gson.annotations.SerializedName

class Itemsum(
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