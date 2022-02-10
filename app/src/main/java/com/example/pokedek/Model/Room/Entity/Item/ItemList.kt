package com.example.pokedek.Model.Room.Entity.Item

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ItemList(
    var nama : String,
    var link : String,
    var type : String
) : Parcelable