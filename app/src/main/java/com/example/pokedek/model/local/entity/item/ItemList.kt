package com.example.pokedek.model.local.entity.item

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ItemList(
    var nama : String,
    var link : String,
    var type : String,
    var effect : String
) : Parcelable