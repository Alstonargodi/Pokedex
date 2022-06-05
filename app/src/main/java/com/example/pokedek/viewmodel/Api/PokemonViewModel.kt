package com.example.pokedek.viewmodel.Api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedek.model.remote.ApiRepository
import com.example.pokedek.model.remote.response.pokemonreponse.Pokemonsum.Pokesummary
import com.example.pokedek.model.remote.response.pokemonreponse.Pokemoves.Pokemoves
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonabilityresponse.Pokeablty
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonlist.Pokemonlist
import retrofit2.Response

class PokemonViewModel(private val apiRepository: ApiRepository): ViewModel() {

    val pokemonlist = MutableLiveData<Response<Pokemonlist>>()
    val pokesumrespon = MutableLiveData<Response<Pokesummary>>()
    val pokeabtrespon : MutableLiveData<Response<Pokeablty>> = MutableLiveData()
    val pokemovesrespon : MutableLiveData<Response<Pokemoves>> = MutableLiveData()

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
//            ApiRepository().getSumPokemon(name).enqueue(object : Callback<Pokesummary> {
//                override fun onResponse(call: Call<Pokesummary>, response: Response<Pokesummary>) {
//                    if (response.isSuccessful)
//                        pokesumrespon.value = response
//                    else
//                        Log.d(TAG,response.message())
//                }
//                override fun onFailure(call: Call<Pokesummary>, t: Throwable) {
//                    Log.d(TAG,t.message.toString())
//                }
//            })
//        }
//    }
//    fun getPokemonAbilty(name: String){
//        viewModelScope.launch {
//            ApiRepository().getAbilityPokemon(name).enqueue(object : Callback<Pokeablty> {
//                override fun onResponse(call: Call<Pokeablty>, response: Response<Pokeablty>) {
//                    if (response.isSuccessful)
//                        pokeabtrespon.value = response
//                    else
//                        Log.d(TAG,response.message())
//                }
//
//                override fun onFailure(call: Call<Pokeablty>, t: Throwable) {
//                    Log.d(TAG,t.message.toString())
//                }
//            })
//        }
//    }
//    fun getPokemonMoves(nameMoves: String){
//        viewModelScope.launch {
//            ApiRepository().getMovesPokemon(nameMoves).enqueue(object : Callback<Pokemoves>{
//                override fun onResponse(call: Call<Pokemoves>, response: Response<Pokemoves>) {
//                    if (response.isSuccessful)
//                        pokemovesrespon.value = response
//                    else
//                        Log.d(TAG,response.message())
//                }
//
//                override fun onFailure(call: Call<Pokemoves>, t: Throwable) {
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