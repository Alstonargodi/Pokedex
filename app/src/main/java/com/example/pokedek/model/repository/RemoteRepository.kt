package com.example.pokedek.model.repository

import androidx.lifecycle.LiveData
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
import com.example.pokedek.model.remote.utils.RemotePaging
import retrofit2.Call

class RemoteRepository (
        private val apiService: ApiService,
    )
{

    //pokemon
    fun getPokemonList(): LiveData<PagingData<PokemonListResult>> {
        return Pager(
            config = PagingConfig(pageSize = 5),
            pagingSourceFactory = { RemotePaging(apiService) }
        ).liveData
    }


    suspend fun getPokemonListTwo(off : Int,limit: Int): LiveData<PokemonListRespon> = liveData {
        apiService.getPokemonList(off, limit)
    }












//    suspend fun getListPokemon(page : Int, limit : Int): LiveData<Fetchstatus<PokemonSummaryResponse>> =
//    liveData {
//        emit(Fetchstatus.Loading)
//        try {
//            apiService.getListPokemon(page,limit).results.forEach {
//                val data = apiService.getSummaryPokemon(it.name)
//                emit(Fetchstatus.Sucess(data))
//            }
//        }catch (e : Exception){
//            emit(Fetchstatus.Error(e.message.toString()))
//        }
//    }


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