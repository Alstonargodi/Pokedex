package com.example.pokedek.model.local.entity.favorite

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "favoriteData")
data class FavoriteData(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val type : String
): Parcelable