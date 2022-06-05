package com.example.pokedek.model.remote.response.pokemonreponse.Pokemonsum


import com.google.gson.annotations.SerializedName

class GenerationIv(
    @SerializedName("diamond-pearl")
    var diamondPearl: DiamondPearl,
    @SerializedName("heartgold-soulsilver")
    var heartgoldSoulsilver: HeartgoldSoulsilver,
    @SerializedName("platinum")
    var platinum: Platinum
)