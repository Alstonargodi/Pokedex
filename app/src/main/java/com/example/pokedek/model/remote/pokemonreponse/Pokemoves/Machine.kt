package com.example.pokedek.model.remote.pokemonreponse.Pokemoves


import com.google.gson.annotations.SerializedName

class Machine(
    @SerializedName("machine")
    var machine: MachineX,
    @SerializedName("version_group")
    var versionGroup: VersionGroupX
)