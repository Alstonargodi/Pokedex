package com.example.pokedek.Model.Api.Pokemonsum


import com.google.gson.annotations.SerializedName

class GenerationVii(
    @SerializedName("icons")
    var icons: Icons,
    @SerializedName("ultra-sun-ultra-moon")
    var ultraSunUltraMoon: UltraSunUltraMoon
)