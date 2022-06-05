package com.example.pokedek.model.Room.Entity.Pokemon

import android.os.Parcelable
import com.example.pokedek.model.remote.response.pokemonreponse.Pokemonsum.Pokesummary
import kotlinx.android.parcel.Parcelize


@Parcelize
data class PokeParcelSum(
    val summary : Pokesummary
):Parcelable
