package com.example.pokedek.model.remote.response.pokemonreponse.Pokemonsum


import com.google.gson.annotations.SerializedName

class VersionGroupDetail(
    @SerializedName("level_learned_at")
    var levelLearnedAt: Int,
    @SerializedName("move_learn_method")
    var moveLearnMethod: MoveLearnMethod,
    @SerializedName("version_group")
    var versionGroup: VersionGroup
)