package com.example.pokedek.Model.Api.Pokemon.Pokemoves


import com.google.gson.annotations.SerializedName

class Pokemoves(
    @SerializedName("accuracy")
    var accuracy: Int,
    @SerializedName("contest_combos")
    var contestCombos: Any,
    @SerializedName("contest_effect")
    var contestEffect: ContestEffect,
    @SerializedName("contest_type")
    var contestType: ContestType,
    @SerializedName("damage_class")
    var damageClass: DamageClass,
    @SerializedName("effect_chance")
    var effectChance: Any,
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
    @SerializedName("learned_by_pokemon")
    var learnedByPokemon: List<LearnedByPokemon>,
    @SerializedName("machines")
    var machines: List<Machine>,
    @SerializedName("meta")
    var meta: Meta,
    @SerializedName("name")
    var name: String,
    @SerializedName("names")
    var names: List<Name>,
    @SerializedName("past_values")
    var pastValues: List<PastValue>,
    @SerializedName("power")
    var power: Int,
    @SerializedName("pp")
    var pp: Int,
    @SerializedName("priority")
    var priority: Int,
    @SerializedName("stat_changes")
    var statChanges: List<Any>,
    @SerializedName("super_contest_effect")
    var superContestEffect: SuperContestEffect,
    @SerializedName("target")
    var target: Target,
    @SerializedName("type")
    var type: Type
)