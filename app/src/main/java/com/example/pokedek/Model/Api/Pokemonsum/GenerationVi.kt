package com.example.pokedek.Model.Api.Pokemonsum


import com.google.gson.annotations.SerializedName

class GenerationVi(
    @SerializedName("omegaruby-alphasapphire")
    var omegarubyAlphasapphire: OmegarubyAlphasapphire,
    @SerializedName("x-y")
    var xY: XY
)