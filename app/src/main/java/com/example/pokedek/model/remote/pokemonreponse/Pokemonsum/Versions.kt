package com.example.pokedek.model.remote.pokemonreponse.Pokemonsum


import com.google.gson.annotations.SerializedName

class Versions(
    @SerializedName("generation-i")
    var generationI: GenerationI,
    @SerializedName("generation-ii")
    var generationIi: GenerationIi,
    @SerializedName("generation-iii")
    var generationIii: GenerationIii,
    @SerializedName("generation-iv")
    var generationIv: GenerationIv,
    @SerializedName("generation-v")
    var generationV: GenerationV,
    @SerializedName("generation-vi")
    var generationVi: GenerationVi,
    @SerializedName("generation-vii")
    var generationVii: GenerationVii,
    @SerializedName("generation-viii")
    var generationViii: GenerationViii
)