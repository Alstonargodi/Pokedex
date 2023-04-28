package com.example.ceritaku_compose.remote

import com.example.ceritaku_compose.remote.response.ListPokemonRespon
import com.example.ceritaku_compose.remote.response.SummaryPokemonRespon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("pokemon")
    suspend fun getListPokemon(
        @Query("offset") off : Int,
        @Query("limit") limit : Int,
    ): ListPokemonRespon

    @GET("pokemon/{name}")
    suspend fun getSummaryPokemon(
        @Path("name") name : String
    ):SummaryPokemonRespon

}