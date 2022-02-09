package com.example.pokedek.Model.Api.Item.Itemsumarry


import com.google.gson.annotations.SerializedName

class HeldByPokemon(
    @SerializedName("pokemon")
    var pokemon: Pokemon,
    @SerializedName("version_details")
    var versionDetails: List<VersionDetail>
)