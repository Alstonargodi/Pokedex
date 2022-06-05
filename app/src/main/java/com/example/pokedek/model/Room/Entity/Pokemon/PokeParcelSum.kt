package com.example.pokedek.model.Room.Entity.Pokemon

import android.os.Parcelable
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonsummaryresponse.PokemonSummaryResponse
import kotlinx.android.parcel.Parcelize


@Parcelize
data class PokeParcelSum(
    val summary : PokemonSummaryResponse
):Parcelable
