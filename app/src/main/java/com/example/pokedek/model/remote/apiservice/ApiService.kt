package com.example.pokedek.model.remote.apiservice

import com.example.pokedek.model.remote.response.berryresponse.berrylistresponse.BerryListResponse
import com.example.pokedek.model.remote.response.berryresponse.berrysummaryresponse.BerrySummaryResponse
import com.example.pokedek.model.remote.response.itemresponse.itemlistresponse.Itemlist
import com.example.pokedek.model.remote.response.itemresponse.itemsummaryresponse.ItemSummaryResponse
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonabilityresponse.PokemonAbilityResponse
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonsummaryresponse.PokemonSummaryResponse
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonmovesresponse.PokemonMovesResponse
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonlistresponse.PokemonListRespon
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonlistresponse.PokemonListResult
import retrofit2.Call
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
    ): PokemonListRespon

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("offset") off : Int,
        @Query("limit") limit : Int,
    ): PokemonListRespon


    @GET("pokemon/{name}/")
    suspend fun getSummaryPokemon(@Path("name") name : String):
            PokemonSummaryResponse

    @GET("ability/{name}/")
    fun getAbilityPokemon(@Path("name") name : String):
            Call<PokemonAbilityResponse>

    @GET("move/{name}/")
    fun getMovesPokemon(@Path("name") name : String):
            Call<PokemonMovesResponse>


    //Berry
    @GET("berry")
    fun getBerryList(
        @Query("offset") off : Int,
        @Query("limit") limit : Int,
    ):Call<BerryListResponse>


    @GET("berry/{name}/")
    fun getBerrySummary(@Path("name") name : String): Call<BerrySummaryResponse>



    //ItemFragment
    @GET("item")
    fun getItemList(
        @Query("offset") off : Int,
        @Query("limit") limit : Int,
    ): Call<Itemlist>


    @GET("item/{idi}/")
    fun getitemsum(
        @Path("idi") idi : String
    ): Call<ItemSummaryResponse>


}

