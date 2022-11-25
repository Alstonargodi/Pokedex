package com.example.pokedek.model.remote.response.pokemonreponse.pokemonlistresponse

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

class PokemonListRespon(
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
@Entity(tableName = "TablePokemonMediator")
class PokemonListResult(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String,
): Parcelable
