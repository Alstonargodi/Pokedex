package com.example.pokedek.model.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.pokedek.model.remote.apiconfig.ApiConfig.getApiService
import com.example.pokedek.model.remote.apiservice.ApiService
import com.example.pokedek.model.remote.response.berryresponse.berrysummaryresponse.BerrySummaryResponse
import com.example.pokedek.model.remote.response.itemresponse.itemlistresponse.Itemlist
import com.example.pokedek.model.remote.response.itemresponse.itemsummaryresponse.ItemSummaryResponse
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonabilityresponse.PokemonAbilityResponse
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonlistresponse.PokemonListRespon
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonlistresponse.PokemonListResult
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonmovesresponse.PokemonMovesResponse
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonsummaryresponse.PokemonSummaryResponse
import com.example.pokedek.model.remote.utils.Fetchstatus
import com.example.pokedek.model.remote.utils.RemotePaging
import retrofit2.Call

class RemoteRepository (private val apiService: ApiService) {
    val pokemonSummary = MutableLiveData<PokemonSummaryResponse>()
    //pokemon
    fun getPokemonList(): LiveData<PagingData<PokemonListResult>> {
        return Pager(
            config = PagingConfig(pageSize = 2),
            pagingSourceFactory = { RemotePaging(apiService) }
        ).liveData
    }

    suspend fun getSummaryPokemon(detailUrl : String): PokemonSummaryResponse {
       return apiService.getSummaryPokemon(detailUrl)
    }

    suspend fun getPokemonListAll(page: Int,limit: Int): LiveData<PokemonListRespon>{
        return liveData { apiService.getPokemonList(page,limit) }
    }
    suspend fun getListPokemon(page : Int, limit : Int): LiveData<Fetchstatus<PokemonSummaryResponse>> =
    liveData {
        emit(Fetchstatus.Loading)
        try {
            apiService.getListPokemon(page,limit).result.forEach {
                if(it == null){
                    Log.d("pokemon","empty")
                }else{
                    val data = apiService.getSummaryPokemon(it.name)
                    Log.d("pokemon","succes")
                    emit(Fetchstatus.Sucess(data))
                }

            }
        }catch (e : Exception){
            Log.d("pokemon",e.toString())
            emit(Fetchstatus.Error(e.message.toString()))
        }
    }


    fun getAbilityPokemon(id: String): Call<PokemonAbilityResponse> =
        getApiService().getAbilityPokemon(id)

    fun getMovesPokemon(id: String): Call<PokemonMovesResponse> =
        getApiService().getMovesPokemon(id)



    //berry
    fun getListBerry(page : Int, limit : Int) =
        getApiService().getBerryList(page,limit)

    fun getSumBerry(id : String): Call<BerrySummaryResponse> =
        getApiService().getBerrySummary(id)

    //item
    fun getListItem(page: Int, limit: Int): Call<Itemlist> =
        getApiService().getItemList(page,limit)

    fun getSumItem(id : String): Call<ItemSummaryResponse> =
        getApiService().getitemsum(id)


    companion object{
        const val TAG = "RemoteRepository"
    }
}