package com.example.pokedek.model.Room.Entity.Pokemon

import android.os.Parcelable
import com.example.pokedek.model.remote.pokemonreponse.Pokemonsum.Pokesummary
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


@Parcelize
data class PokeParcelSum(
    val summary : Pokesummary
):Parcelable
