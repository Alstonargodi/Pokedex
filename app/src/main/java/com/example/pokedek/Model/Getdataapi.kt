package com.example.pokedek.Model

import com.example.pokedek.Model.Pokemonsum.Pokesummary
import com.example.pokedek.Model.pokemonlist.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


//"https://pokeapi.co/api/v2"

interface Getdataapi {

    @GET("pokemon")
    suspend fun getlist(): Response<Pokemon>


    @GET("{id}/")
    suspend fun getsum(
        @Path("id") id : Int
    ): Response<Pokesummary>



}

