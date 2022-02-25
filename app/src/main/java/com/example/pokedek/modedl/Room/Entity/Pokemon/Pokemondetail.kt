package com.example.pokedek.modedl.Room.Entity.Pokemon

import com.example.pokedek.modedl.Api.Pokemon.Pokemonsum.Ability

data class Pokemondetail(
    val name: String,
    val height: Int,
    val width: Int,
    val Ablty: List<Ability>?,
)
{
}