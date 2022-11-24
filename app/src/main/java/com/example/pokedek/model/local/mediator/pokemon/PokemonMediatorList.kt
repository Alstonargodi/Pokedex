package com.example.pokedek.model.local.mediator.pokemon

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "TablePokemonMediator")
data class PokemonMediatorList(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String,
): Parcelable
