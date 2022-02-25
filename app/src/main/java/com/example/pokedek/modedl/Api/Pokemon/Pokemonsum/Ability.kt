package com.example.pokedek.modedl.Api.Pokemon.Pokemonsum


import com.google.gson.annotations.SerializedName

class Ability(
    @SerializedName("ability")
    var ability: AbilityX,
    @SerializedName("is_hidden")
    var isHidden: Boolean,
    @SerializedName("slot")
    var slot: Int
)