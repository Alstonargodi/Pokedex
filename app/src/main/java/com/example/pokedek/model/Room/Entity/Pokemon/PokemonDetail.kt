package com.example.pokedek.model.Room.Entity.Pokemon

import com.example.pokedek.model.remote.response.pokemonreponse.Pokemonsum.Ability

data class PokemonDetail(
    val name: String,
    val height: Int,
    val width: Int,
    val Ablty: List<Ability>?,
)
{
}