package com.example.pokedek.model.remote.itemresponse.itemlistresponse

data class Itemlist(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)