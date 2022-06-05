package com.example.pokedek.model.remote.response.pokemonreponse.pokemonmovesresponse


import com.google.gson.annotations.SerializedName

class PokemonMovesResponse(
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

class Ailment(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

class ContestEffect(
    @SerializedName("url")
    var url: String
)
class Category(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

class ContestType(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

class DamageClass(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
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

class LearnedByPokemon(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

class Machine(
    @SerializedName("machine")
    var machine: MachineX,
)

class MachineX(
    @SerializedName("url")
    var url: String
)

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

class Name(
    @SerializedName("name")
    var name: String
)

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
)

class SuperContestEffect(
    @SerializedName("url")
    var url: String
)

class Target(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

class Type(
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