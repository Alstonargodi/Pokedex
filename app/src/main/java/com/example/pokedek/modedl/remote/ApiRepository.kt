package com.example.pokedek.modedl.remote

import com.example.pokedek.modedl.remote.berryresponse.berrysumresponse.BerrySumResponse
import com.example.pokedek.modedl.remote.itemresponse.itemlistresponse.Itemlist
import com.example.pokedek.modedl.remote.itemresponse.itemsumreponse.Itemsum
import com.example.pokedek.modedl.remote.pokemonreponse.pokemonabilityresponse.Pokeablty
import com.example.pokedek.modedl.remote.pokemonreponse.Pokemonsum.Pokesummary
import com.example.pokedek.modedl.remote.pokemonreponse.Pokemoves.Pokemoves
import com.example.pokedek.modedl.remote.ApiConfig.getApiService
import com.example.pokedek.modedl.remote.pokemonreponse.pokemonlist.Pokemonlist
import retrofit2.Call
import retrofit2.Response

class ApiRepository() {

    //pokemon
    fun getListPokemon(page : Int, limit : Int): Call<Pokemonlist> = getApiService().getListPokemon(page,limit)

    fun getSumPokemon(id : String): Call<Pokesummary> =  getApiService().getSummaryPokemon(id)

    fun getAbilityPokemon(id: String): Call<Pokeablty> = getApiService().getAbilityPokemon(id)

    suspend fun getMovesPokemon(id: String): Response<Pokemoves> = getApiService().getmovessum(id)

    //berry
    suspend fun getListBerry(page : Int, limit : Int) = getApiService().getberrylist(page,limit)

    suspend fun getSumBerry(id : String): Response<BerrySumResponse> = getApiService().getberrysum(id)

    //item
    suspend fun getListItem(page: Int, limit: Int): Response<Itemlist> = getApiService().getitemlist(page,limit)

    suspend fun getSumItem(id : String): Response<Itemsum> = getApiService().getitemsum(id)

}