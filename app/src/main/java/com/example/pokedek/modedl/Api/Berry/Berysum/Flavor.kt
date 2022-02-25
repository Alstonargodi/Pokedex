package com.example.pokedek.modedl.Api.Berry.Berysum


import com.google.gson.annotations.SerializedName

class Flavor(
    @SerializedName("flavor")
    var flavor: FlavorX,
    @SerializedName("potency")
    var potency: Int
)