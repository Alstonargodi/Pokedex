package com.example.pokedek.model.local.mediator.pokemon

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class PokemonMediatorList(
    @PrimaryKey
    var id : Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String,
)
