package com.example.pokedek.model.remote

import com.example.pokedek.model.remote.berryresponse.berrysumresponse.BerrySumResponse
import com.example.pokedek.model.remote.itemresponse.itemlistresponse.Itemlist
import com.example.pokedek.model.remote.itemresponse.itemsumreponse.Itemsum
import com.example.pokedek.model.remote.pokemonreponse.pokemonabilityresponse.Pokeablty
import com.example.pokedek.model.remote.pokemonreponse.Pokemonsum.Pokesummary
import com.example.pokedek.model.remote.pokemonreponse.Pokemoves.Pokemoves
import com.example.pokedek.model.remote.ApiConfig.getApiService
import com.example.pokedek.model.remote.pokemonreponse.pokemonlist.Pokemonlist
import retrofit2.Call
import retrofit2.Response

class ApiRepository() {

    //pokemon
    fun getListPokemon(page : Int, limit : Int): Call<Pokemonlist> = getApiService().getListPokemon(page,limit)

    fun getSumPokemon(id : String): Call<Pokesummary> =  getApiService().getSummaryPokemon(id)

    fun getAbilityPokemon(id: String): Call<Pokeablty> = getApiService().getAbilityPokemon(id)

    fun getMovesPokemon(id: String): Call<Pokemoves> = getApiService().getMovesPokemon(id)

    //berry
    suspend fun getListBerry(page : Int, limit : Int) = getApiService().getberrylist(page,limit)

    suspend fun getSumBerry(id : String): Response<BerrySumResponse> = getApiService().getberrysum(id)

    //item
    suspend fun getListItem(page: Int, limit: Int): Response<Itemlist> = getApiService().getitemlist(page,limit)

    suspend fun getSumItem(id : String): Response<Itemsum> = getApiService().getitemsum(id)

}