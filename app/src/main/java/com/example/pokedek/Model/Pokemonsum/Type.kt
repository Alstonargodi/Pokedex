package com.example.pokedek.Model.Pokemonsum


import com.google.gson.annotations.SerializedName

class Type(
    @SerializedName("slot")
    var slot: Int,
    @SerializedName("type")
    var type: TypeX
)