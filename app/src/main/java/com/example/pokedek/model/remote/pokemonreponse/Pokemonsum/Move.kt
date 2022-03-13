package com.example.pokedek.model.remote.pokemonreponse.Pokemonsum


import com.google.gson.annotations.SerializedName

class Move(
    @SerializedName("move")
    var move: MoveX,
    @SerializedName("version_group_details")
    var versionGroupDetails: List<VersionGroupDetail>
)