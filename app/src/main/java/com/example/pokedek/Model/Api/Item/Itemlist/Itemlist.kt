package com.example.pokedek.Model.Api.Item.Itemlist

data class Itemlist(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)