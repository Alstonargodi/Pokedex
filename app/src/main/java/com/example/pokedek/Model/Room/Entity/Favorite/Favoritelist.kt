package com.example.pokedek.Model.Room.Entity.Favorite

import android.os.Parcelable
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Index
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