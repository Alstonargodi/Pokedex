package com.example.pokedek.model.remote.pokemonreponse.Pokemonsum


import com.google.gson.annotations.SerializedName

class Other(
    @SerializedName("dream_world")
    var dreamWorld: DreamWorld,
    @SerializedName("home")
    var home: Home,
    @SerializedName("official-artwork")
    var officialArtwork: OfficialArtwork
)