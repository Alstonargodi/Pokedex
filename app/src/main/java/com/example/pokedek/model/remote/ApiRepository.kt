package com.example.pokedek.model.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.pokedek.model.Room.Entity.Pokemon.PokemonSummary
import com.example.pokedek.model.remote.berryresponse.berrysumresponse.BerrySumResponse
import com.example.pokedek.model.remote.itemresponse.itemlistresponse.Itemlist
import com.example.pokedek.model.remote.itemresponse.itemsumreponse.Itemsum
import com.example.pokedek.model.remote.pokemonreponse.pokemonabilityresponse.Pokeablty
import com.example.pokedek.model.remote.pokemonreponse.Pokemonsum.Pokesummary
import com.example.pokedek.model.remote.pokemonreponse.Pokemoves.Pokemoves
import com.example.pokedek.model.remote.ApiConfig.getApiService
import com.example.pokedek.model.remote.pokemonreponse.pokemonlist.Pokemonlist
import com.example.pokedek.model.remote.pokemonreponse.pokemonlist.Result
import com.example.pokedek.view.utils.AppExecutors
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

    fun getSumBerry(id : String): Call<BerrySumResponse> = getApiService().getBerrySummary(id)

    //item
    fun getListItem(page: Int, limit: Int): Call<Itemlist> = getApiService().getItemList(page,limit)

    fun getSumItem(id : String): Call<Itemsum> = getApiService().getitemsum(id)


    companion object{
        const val TAG = "ApiRepository"

    }
}