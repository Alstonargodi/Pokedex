package com.example.pokedek.modedl.remote.pokemonreponse.Pokemonsum


import com.google.gson.annotations.SerializedName

class GenerationVi(
    @SerializedName("omegaruby-alphasapphire")
    var omegarubyAlphasapphire: OmegarubyAlphasapphire,
    @SerializedName("x-y")
    var xY: XY
)