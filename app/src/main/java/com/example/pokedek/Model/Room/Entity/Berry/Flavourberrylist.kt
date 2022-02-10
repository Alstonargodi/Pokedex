package com.example.pokedek.Model.Room.Entity.Berry

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Flavourberrylist(
    val name : String,
    val potecny : String,
): Parcelable
