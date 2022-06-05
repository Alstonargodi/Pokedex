package com.example.pokedek.model.remote.response.itemresponse.itemlistresponse

data class Itemlist(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)

data class Result(
    val name: String,
    val url: String
)