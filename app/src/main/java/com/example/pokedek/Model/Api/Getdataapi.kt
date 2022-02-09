package com.example.pokedek.Model.Api

import com.example.pokedek.Model.Api.Berry.BerryList.Berrylist
import com.example.pokedek.Model.Api.Berry.Berysum.Berrysum
import com.example.pokedek.Model.Api.Item.Itemlist.Itemlist
import com.example.pokedek.Model.Api.Item.Itemsumarry.Itemsum
import com.example.pokedek.Model.Api.Pokemon.Pokeablity.Pokeablty
import com.example.pokedek.Model.Api.Pokemon.Pokemonsum.Pokesummary
import com.example.pokedek.Model.Api.Pokemon.Pokemoves.Pokemoves
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
        @Query("offset") off : Int,
        @Query("limit") limit : Int,
    ): Response<Pokemonlist>

    //Pokemon Summary
    @GET("pokemon/{id}/")
    suspend fun getsum(
        @Path("id") id : String
    ): Response<Pokesummary>

    //Pokemon ability
    @GET("ability/{ida}/")
    suspend fun getabltysum(
        @Path("ida") ida : String
    ): Response<Pokeablty>

    //Pokemon moves
    @GET("move/{idb}/")
    suspend fun getmovessum(
        @Path("idb") idb : String
    ): Response<Pokemoves>


    //Berry list
    @GET("berry")
    suspend fun getberrylist(
        @Query("offset") off : Int,
        @Query("limit") limit : Int,
    ):Response<Berrylist>


    //berrysum
    @GET("berry/{idbe}/")
    suspend fun getberrysum(
        @Path("idbe") idbe : String
    ): Response<Berrysum>


    //itemlist
    @GET("item")
    suspend fun getitemlist(
        @Query("offset") off : Int,
        @Query("limit") limit : Int,
    ): Response<Itemlist>

    //item sum
    @GET("item/{idi}/")
    suspend fun getitemsum(
        @Path("idi") idi : String
    ): Response<Itemsum>


}

