package com.example.pokedek.viewmodel.remote

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pokedek.model.repository.RemoteRepository
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonsummaryresponse.PokemonSummaryResponse
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonmovesresponse.PokemonMovesResponse
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonabilityresponse.PokemonAbilityResponse
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonlistresponse.PokemonListRespon
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonlistresponse.PokemonListResult
import retrofit2.Response

class PokemonViewModel(private val remoteRepository: RemoteRepository): ViewModel() {

    val pokemonlist = MutableLiveData<Response<PokemonListRespon>>()
    val pokesumrespon = MutableLiveData<Response<PokemonSummaryResponse>>()
    val pokeabtrespon : MutableLiveData<Response<PokemonAbilityResponse>> = MutableLiveData()
    val pokemovesrespon : MutableLiveData<Response<PokemonMovesResponse>> = MutableLiveData()

    //pokemon
    fun getListPokemon(): LiveData<PagingData<PokemonListResult>> =
        remoteRepository.getPokemonList().cachedIn(viewModelScope)

    fun getPokemonSummary(detailUrl : String): LiveData<PokemonSummaryResponse>{
        return liveData { remoteRepository.getSummaryPokemon(detailUrl) }
    }

    suspend fun getAll(page: Int,limit: Int): LiveData<PokemonListRespon>{
        return liveData { remoteRepository.getPokemonListAll(page, limit) }
    }

    suspend fun getAllPokemon(page : Int, limit : Int): LiveData<PokemonListRespon>{
        return liveData {
            Log.d("pokemon",remoteRepository.getListPokemon(page, limit).value.toString())
            remoteRepository.getListPokemon(page, limit)
        }
    }
//    fun getPokemonSummary(name : String){
//        viewModelScope.launch{
//            RemoteRepository().getSumPokemon(name).enqueue(object : Callback<PokemonSummaryResponse> {
//                override fun onResponse(call: Call<PokemonSummaryResponse>, response: Response<PokemonSummaryResponse>) {
//                    if (response.isSuccessful)
//                        pokesumrespon.value = response
//                    else
//                        Log.d(TAG,response.message())
//                }
//                override fun onFailure(call: Call<PokemonSummaryResponse>, t: Throwable) {
//                    Log.d(TAG,t.message.toString())
//                }
//            })
//        }
//    }
//    fun getPokemonAbilty(name: String){
//        viewModelScope.launch {
//            RemoteRepository().getAbilityPokemon(name).enqueue(object : Callback<PokemonAbilityResponse> {
//                override fun onResponse(call: Call<PokemonAbilityResponse>, response: Response<PokemonAbilityResponse>) {
//                    if (response.isSuccessful)
//                        pokeabtrespon.value = response
//                    else
//                        Log.d(TAG,response.message())
//                }
//
//                override fun onFailure(call: Call<PokemonAbilityResponse>, t: Throwable) {
//                    Log.d(TAG,t.message.toString())
//                }
//            })
//        }
//    }
//    fun getPokemonMoves(nameMoves: String){
//        viewModelScope.launch {
//            RemoteRepository().getMovesPokemon(nameMoves).enqueue(object : Callback<PokemonMovesResponse>{
//                override fun onResponse(call: Call<PokemonMovesResponse>, response: Response<PokemonMovesResponse>) {
//                    if (response.isSuccessful)
//                        pokemovesrespon.value = response
//                    else
//                        Log.d(TAG,response.message())
//                }
//
//                override fun onFailure(call: Call<PokemonMovesResponse>, t: Throwable) {
//                    Log.d(TAG,t.message.toString())
//                }
//
//            })
//        }
//    }

    companion object{
        const val TAG = "PokemonViewModel"
    }

}