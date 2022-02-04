package com.example.pokedek.Model.Room.Entity.Berry

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Berrylist(
    val name : String,
    val link : String,
): Parcelable
