package com.example.pokedek.Model.Api.Pokemon.Pokemoves


import com.google.gson.annotations.SerializedName

class Machine(
    @SerializedName("machine")
    var machine: MachineX,
    @SerializedName("version_group")
    var versionGroup: VersionGroupX
)