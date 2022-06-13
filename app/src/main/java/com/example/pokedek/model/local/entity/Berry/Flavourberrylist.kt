package com.example.pokedek.model.local.entity.Berry

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Flavourberrylist(
    val name : String,
    val potecny : String,
): Parcelable
