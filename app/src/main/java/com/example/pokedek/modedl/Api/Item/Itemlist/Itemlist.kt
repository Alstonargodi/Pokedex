package com.example.pokedek.modedl.Api.Item.Itemlist

data class Itemlist(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)