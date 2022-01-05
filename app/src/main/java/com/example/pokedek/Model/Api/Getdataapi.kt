package com.example.pokedek.Model.Api

import com.example.pokedek.Model.Api.Pokemonsum.Pokesummary
import com.example.pokedek.Model.Api.pokemonlist.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


//"https://pokeapi.co/api/v2"

interface Getdataapi {

    @GET("pokemon")
    suspend fun getlist(
    ): Response<Pokemon>

    //        @Query("offset")  offser : Int = 0,
    //        @Query("limit") limit : Int = 2

    @GET("{id}/")
    suspend fun getsum(
        @Path("id") id : String
    ): Response<Pokesummary>



}

