package com.example.pokedek.viewmodel.Api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedek.model.remote.ApiRepository
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonsummaryresponse.PokemonSummaryResponse
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonmovesresponse.PokemonMovesResponse
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonabilityresponse.PokemonAbilityResponse
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonlistresponse.Pokemonlist
import retrofit2.Response

class PokemonViewModel(private val apiRepository: ApiRepository): ViewModel() {

    val pokemonlist = MutableLiveData<Response<Pokemonlist>>()
    val pokesumrespon = MutableLiveData<Response<PokemonSummaryResponse>>()
    val pokeabtrespon : MutableLiveData<Response<PokemonAbilityResponse>> = MutableLiveData()
    val pokemovesrespon : MutableLiveData<Response<PokemonMovesResponse>> = MutableLiveData()

    //pokemon
    suspend fun getListPokemon(page: Int, limit: Int) = apiRepository.getListPokemon(page, limit)


//    fun getPokemonList(page: Int, limit: Int){
//        viewModelScope.launch {
//            ApiRepository().getListPokemon(page, limit).enqueue(object : Callback<Pokemonlist> {
//                override fun onResponse(call: Call<Pokemonlist>, response: Response<Pokemonlist>) {
//                    if (response.isSuccessful)
//                        pokelistrespon.value = response.body()
//                    else
//                        Log.d(TAG,response.message())
//                }
//
//                override fun onFailure(call: Call<Pokemonlist>, t: Throwable) {
//                    Log.d(TAG,t.message.toString())
//                }
//
//            })
//        }
//    }

//    fun getPokemonSummary(name : String){
//        viewModelScope.launch{
//            ApiRepository().getSumPokemon(name).enqueue(object : Callback<PokemonSummaryResponse> {
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
//            ApiRepository().getAbilityPokemon(name).enqueue(object : Callback<PokemonAbilityResponse> {
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
//            ApiRepository().getMovesPokemon(nameMoves).enqueue(object : Callback<PokemonMovesResponse>{
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