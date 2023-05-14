package com.example.ceritaku_compose.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

class ListPokemonRespon(
    @SerializedName("count")
    var count: Int,
    @SerializedName("next")
    var next: String,
    @SerializedName("previous")
    var previous: Any,
    @SerializedName("results")
    var results: List<PokemonListResult>,
)

@Parcelize
class PokemonListResult(
    var id : Int = 0,
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String,
): Parcelable