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
    fun getListBerry(page : Int, limit : Int) = getApiService().getBerryList(page,limit)

    fun getSumBerry(id : String): Call<BerrySumResponse> = getApiService().getBerrySummary(id)

    //item
    fun getListItem(page: Int, limit: Int): Call<Itemlist> = getApiService().getItemList(page,limit)

    fun getSumItem(id : String): Call<Itemsum> = getApiService().getitemsum(id)

}