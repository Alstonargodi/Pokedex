package com.example.pokedek.viewmodel.remote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedek.model.repository.RemoteRepository
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonsummaryresponse.PokemonSummaryResponse
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonmovesresponse.PokemonMovesResponse
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonabilityresponse.PokemonAbilityResponse
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonlistresponse.Pokemonlist
import retrofit2.Response

class PokemonViewModel(private val remoteRepository: RemoteRepository): ViewModel() {

    val pokemonlist = MutableLiveData<Response<Pokemonlist>>()
    val pokesumrespon = MutableLiveData<Response<PokemonSummaryResponse>>()
    val pokeabtrespon : MutableLiveData<Response<PokemonAbilityResponse>> = MutableLiveData()
    val pokemovesrespon : MutableLiveData<Response<PokemonMovesResponse>> = MutableLiveData()

    //pokemon
    suspend fun getListPokemon(page: Int, limit: Int) =
        remoteRepository.getListPokemon(page, limit)



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