package com.example.pokedek.model.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.pokedek.model.remote.response.berryresponse.berrysummaryresponse.BerrySummaryResponse
import com.example.pokedek.model.remote.response.itemresponse.itemlistresponse.Itemlist
import com.example.pokedek.model.remote.response.itemresponse.itemsummaryresponse.ItemSummaryResponse
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonabilityresponse.Pokeablty
import com.example.pokedek.model.remote.response.pokemonreponse.Pokemonsum.Pokesummary
import com.example.pokedek.model.remote.response.pokemonreponse.Pokemoves.Pokemoves
import com.example.pokedek.model.remote.ApiConfig.getApiService
import retrofit2.Call
import java.lang.Exception

class ApiRepository (
        private val apiService: ApiService,
    ) {

    //pokemon
    suspend fun getListPokemon(page : Int, limit : Int): LiveData<Fetchstatus<Pokesummary>> = liveData {
        emit(Fetchstatus.Loading)
        try {
            apiService.getListPokemon(page,limit).results.forEach {
                val data = apiService.getSummaryPokemon(it.name)
                emit(Fetchstatus.Sucess(data))
            }
        }catch (e : Exception){
            emit(Fetchstatus.Error(e.message.toString()))
        }
    }


    fun getAbilityPokemon(id: String): Call<Pokeablty> = getApiService().getAbilityPokemon(id)

    fun getMovesPokemon(id: String): Call<Pokemoves> = getApiService().getMovesPokemon(id)



    //berry
    fun getListBerry(page : Int, limit : Int) = getApiService().getBerryList(page,limit)

    fun getSumBerry(id : String): Call<BerrySummaryResponse> = getApiService().getBerrySummary(id)

    //item
    fun getListItem(page: Int, limit: Int): Call<Itemlist> = getApiService().getItemList(page,limit)

    fun getSumItem(id : String): Call<ItemSummaryResponse> = getApiService().getitemsum(id)


    companion object{
        const val TAG = "ApiRepository"

    }
}