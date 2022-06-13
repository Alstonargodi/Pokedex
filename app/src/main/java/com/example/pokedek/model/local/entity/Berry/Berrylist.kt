package com.example.pokedek.model.local.entity.Berry

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Berrylist(
    val name : String,
    val link : String,
): Parcelable
