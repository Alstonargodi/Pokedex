package com.example.pokedek.modedl.remote

import com.example.pokedek.modedl.remote.berryresponse.berrylistresponse.BerryListResponse
import com.example.pokedek.modedl.remote.berryresponse.berrysumresponse.BerrySumResponse
import com.example.pokedek.modedl.remote.itemresponse.itemlistresponse.Itemlist
import com.example.pokedek.modedl.remote.itemresponse.itemsumreponse.Itemsum
import com.example.pokedek.modedl.remote.pokemonreponse.pokemonabilityresponse.Pokeablty
import com.example.pokedek.modedl.remote.pokemonreponse.Pokemonsum.Pokesummary
import com.example.pokedek.modedl.remote.pokemonreponse.Pokemoves.Pokemoves
import com.example.pokedek.modedl.remote.pokemonreponse.pokemonlist.Pokemonlist
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//"https://pokeapi.co/api/v2"
interface ApiService {

    //Pokemon
    @GET("pokemon")
    fun getListPokemon(
        @Query("offset") off : Int,
        @Query("limit") limit : Int,
    ): Call<Pokemonlist>


    @GET("pokemon/{name}/")
    fun getSummaryPokemon(
        @Path("name") name : String
    ): Call<Pokesummary>


    @GET("ability/{ida}/")
    fun getAbilityPokemon(
        @Path("ida") ida : String
    ): Call<Pokeablty>

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
    ):Response<BerryListResponse>


    //berrysum
    @GET("berry/{idbe}/")
    suspend fun getberrysum(
        @Path("idbe") idbe : String
    ): Response<BerrySumResponse>


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

