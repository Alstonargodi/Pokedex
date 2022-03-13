package com.example.pokedek.model.remote.itemresponse.itemsumreponse


import com.google.gson.annotations.SerializedName

class HeldByPokemon(
    @SerializedName("pokemon")
    var pokemon: Pokemon,
    @SerializedName("version_details")
    var versionDetails: List<VersionDetail>
)