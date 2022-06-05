package com.example.pokedek.model.local.Entity.Pokemon

import com.example.pokedek.model.remote.response.pokemonreponse.pokemonsummaryresponse.Ability

data class PokemonDetail(
    val name: String,
    val height: Int,
    val width: Int,
    val Ablty: List<Ability>?,
)
{
}