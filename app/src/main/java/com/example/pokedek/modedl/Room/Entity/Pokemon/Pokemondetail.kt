package com.example.pokedek.modedl.Room.Entity.Pokemon

import com.example.pokedek.modedl.remote.pokemonreponse.Pokemonsum.Ability

data class Pokemondetail(
    val name: String,
    val height: Int,
    val width: Int,
    val Ablty: List<Ability>?,
)
{
}