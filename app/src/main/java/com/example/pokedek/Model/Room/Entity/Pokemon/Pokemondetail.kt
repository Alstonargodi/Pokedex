package com.example.pokedek.Model.Room.Entity.Pokemon

import com.example.pokedek.Model.Api.Pokemon.Pokemonsum.Ability

data class Pokemondetail(
    val name: String,
    val height: Int,
    val width: Int,
    val Ablty: List<Ability>?,
)
{
}