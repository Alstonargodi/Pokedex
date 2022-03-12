package com.example.pokedek.viewmodel.Api

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedek.modedl.Room.Entity.Pokemon.PokemonSum
import com.example.pokedek.modedl.remote.berryresponse.berrylistresponse.BerryListResponse
import com.example.pokedek.modedl.remote.berryresponse.berrysumresponse.BerrySumResponse
import com.example.pokedek.modedl.remote.itemresponse.itemlistresponse.Itemlist
import com.example.pokedek.modedl.remote.itemresponse.itemsumreponse.Itemsum
import com.example.pokedek.modedl.remote.pokemonreponse.pokemonabilityresponse.Pokeablty
import com.example.pokedek.modedl.remote.ApiRepository
import com.example.pokedek.modedl.remote.pokemonreponse.Pokemonsum.Pokesummary
import com.example.pokedek.modedl.remote.pokemonreponse.Pokemoves.Pokemoves
import com.example.pokedek.modedl.remote.pokemonreponse.pokemonlist.Pokemonlist
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Apiviewmodel : ViewModel(){
    val pokelistrespon : MutableLiveData<Pokemonlist> = MutableLiveData()
    val pokesumrespon : MutableLiveData<Response<Pokesummary>> = MutableLiveData()
    val pokeabtrespon : MutableLiveData<Response<Pokeablty>> = MutableLiveData()
    val pokemovesrespon : MutableLiveData<Response<Pokemoves>> = MutableLiveData()

    val berrylistrespon : MutableLiveData<Response<BerryListResponse>> = MutableLiveData()
    val berrysumrespon : MutableLiveData<Response<BerrySumResponse>> = MutableLiveData()

    val itemlistrespon : MutableLiveData<Response<Itemlist>> = MutableLiveData()
    val itemsumrespon : MutableLiveData<Response<Itemsum>> = MutableLiveData()

    //pokemon
    fun getPokemonList(page: Int, limit: Int){
        viewModelScope.launch {
            ApiRepository().getListPokemon(page, limit).enqueue(object : Callback<Pokemonlist>{
                override fun onResponse(call: Call<Pokemonlist>, response: Response<Pokemonlist>) {
                   pokelistrespon.value = response.body()
                }

                override fun onFailure(call: Call<Pokemonlist>, t: Throwable) {
                    Log.d("pokemon",t.message.toString())
                }

            })
        }
    }

    fun getPokemonSummary(name : String){
        viewModelScope.launch{
            ApiRepository().getSumPokemon(name).enqueue(object : Callback<Pokesummary>{
                override fun onResponse(call: Call<Pokesummary>, response: Response<Pokesummary>) {
                    if (response.isSuccessful)
                        pokesumrespon.value = response
                    else
                        Log.d("PokemonSummary",response.message())
                }
                override fun onFailure(call: Call<Pokesummary>, t: Throwable) {
                    Log.d("PokemonSummary",t.message.toString())
                }
            })
        }
    }
    fun getPokemonAbilty(name: String){
        viewModelScope.launch {
            ApiRepository().getAbilityPokemon(name).enqueue(object : Callback<Pokeablty>{
                override fun onResponse(call: Call<Pokeablty>, response: Response<Pokeablty>) {
                    pokeabtrespon.value = response
                }

                override fun onFailure(call: Call<Pokeablty>, t: Throwable) {
                    Log.d("pokemon",t.message.toString())
                }
            })
        }
    }
    fun getpokemoves(id: String){
        viewModelScope.launch {
            pokemovesrespon.value = ApiRepository().getMovesPokemon(id)
        }
    }

    //berry
    fun getberrylist(page: Int,limit: Int){
        viewModelScope.launch {
            berrylistrespon.value = ApiRepository().getListBerry(page, limit)
        }
    }

    fun getberrysum(id:String){
        viewModelScope.launch {
            berrysumrespon.value = ApiRepository().getSumBerry(id)
        }
    }

    //item
    fun getitemlist(page: Int,limit: Int){
        viewModelScope.launch {
            itemlistrespon.value = ApiRepository().getListItem(page, limit)
        }
    }

    fun getitemsum(id: String){
        viewModelScope.launch {
            itemsumrespon.value = ApiRepository().getSumItem(id)
        }
    }



}