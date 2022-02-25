package com.example.pokedek.modedl.Room.Entity.Favorite

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tabelfavorit")
data class Favoritelist(
    @PrimaryKey(autoGenerate = true)
    val number : Int,
    val name : String,
    val type : String,
    val date : String,
    val link : String,
): Parcelable


@Parcelize
data class badan(
    @PrimaryKey(autoGenerate = true)
    val number : Int,
    val name : String,
    val type : String,
    val date : String,
    val link : String,
): Parcelable