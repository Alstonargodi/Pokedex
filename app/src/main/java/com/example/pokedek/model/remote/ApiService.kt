package com.example.pokedek.model.remote

import com.example.pokedek.model.remote.berryresponse.berrylistresponse.BerryListResponse
import com.example.pokedek.model.remote.berryresponse.berrysumresponse.BerrySumResponse
import com.example.pokedek.model.remote.itemresponse.itemlistresponse.Itemlist
import com.example.pokedek.model.remote.itemresponse.itemsumreponse.Itemsum
import com.example.pokedek.model.remote.pokemonreponse.pokemonabilityresponse.Pokeablty
import com.example.pokedek.model.remote.pokemonreponse.Pokemonsum.Pokesummary
import com.example.pokedek.model.remote.pokemonreponse.Pokemoves.Pokemoves
import com.example.pokedek.model.remote.pokemonreponse.pokemonlist.Pokemonlist
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//"https://pokeapi.co/api/v2"
interface ApiService {

    //Pokemon
    @GET("pokemon")
    suspend fun getListPokemon(
        @Query("offset") off : Int,
        @Query("limit") limit : Int,
    ): Pokemonlist

    @GET("pokemon/{name}/")
    suspend fun getSummaryPokemon(@Path("name") name : String): Pokesummary


    @GET("ability/{name}/")
    fun getAbilityPokemon(@Path("name") name : String): Call<Pokeablty>

    @GET("move/{name}/")
    fun getMovesPokemon(@Path("name") name : String): Call<Pokemoves>


    //Berry
    @GET("berry")
    fun getBerryList(
        @Query("offset") off : Int,
        @Query("limit") limit : Int,
    ):Call<BerryListResponse>


    @GET("berry/{name}/")
    fun getBerrySummary(@Path("name") name : String): Call<BerrySumResponse>



    //ItemFragment
    @GET("item")
    fun getItemList(
        @Query("offset") off : Int,
        @Query("limit") limit : Int,
    ): Call<Itemlist>


    @GET("item/{idi}/")
    fun getitemsum(
        @Path("idi") idi : String
    ): Call<Itemsum>


}

