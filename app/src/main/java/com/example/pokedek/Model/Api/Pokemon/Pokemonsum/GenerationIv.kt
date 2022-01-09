package com.example.pokedek.Model.Api.Pokemon.Pokemonsum


import com.google.gson.annotations.SerializedName

class GenerationIv(
    @SerializedName("diamond-pearl")
    var diamondPearl: DiamondPearl,
    @SerializedName("heartgold-soulsilver")
    var heartgoldSoulsilver: HeartgoldSoulsilver,
    @SerializedName("platinum")
    var platinum: Platinum
)