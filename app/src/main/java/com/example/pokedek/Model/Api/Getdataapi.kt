package com.example.pokedek.Model.Api

import com.example.pokedek.Model.Api.Berry.BerryList.Berrylist
import com.example.pokedek.Model.Api.Pokemon.Pokeablity.Pokeablty
import com.example.pokedek.Model.Api.Pokemon.Pokemonsum.Pokesummary
import com.example.pokedek.Model.Api.Pokemon.pokemonlist.Pokemonlist
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//"https://pokeapi.co/api/v2"

interface Getdataapi {

    //Pokemon list
    @GET("pokemon")
    suspend fun getlist(
    ): Response<Pokemonlist>
    //        @Query("offset")  offser : Int = 0,
    //        @Query("limit") limit : Int = 2

    //Pokemon Summary
    @GET("{id}/")
    suspend fun getsum(
        @Path("id") id : String
    ): Response<Pokesummary>


    //Pokemon ability
    @GET("{ida}/")
    suspend fun getablty(
        @Path("ida") ida : String
    ): Response<Pokeablty>


    //Berry list
    @GET("berry")
    suspend fun getberrylist():Response<Berrylist>



}

