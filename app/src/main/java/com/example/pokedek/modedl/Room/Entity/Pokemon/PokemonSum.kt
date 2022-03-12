package com.example.pokedek.modedl.Room.Entity.Pokemon

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "pokemonlist")
data class PokemonSum(
    @PrimaryKey(autoGenerate = false)
    val name : String,
    val image : String,
    val height : String,
    val weight : String,
    val power : String,
    val attack : String,
    val speed : String,
    val types : String,
    val abilityOne : String,
    val abilityTwo : String,
    val sAttack : String,
    val sDefence : String
): Parcelable
