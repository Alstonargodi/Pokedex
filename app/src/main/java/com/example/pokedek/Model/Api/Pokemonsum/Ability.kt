package com.example.pokedek.Model.Api.Pokemonsum


import com.google.gson.annotations.SerializedName

class Ability(
    @SerializedName("ability")
    var ability: AbilityX,
    @SerializedName("is_hidden")
    var isHidden: Boolean,
    @SerializedName("slot")
    var slot: Int
)