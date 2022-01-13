package com.example.pokedek.Model.Room.Entity.Pokemon

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "pokemonlist")
data class Pokemonlist(
    @PrimaryKey(autoGenerate = false)
    val nama : String,
    val link : String,
    val tinggi : String,
    val berat : String
): Parcelable
