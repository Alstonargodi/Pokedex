package com.example.pokedek.Viewmodel.Api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedek.Model.Api.Berry.BerryList.Berrylist
import com.example.pokedek.Model.Api.Berry.Berysum.Berrysum
import com.example.pokedek.Model.Api.Item.Itemlist.Itemlist
import com.example.pokedek.Model.Api.Item.Itemsumarry.Itemsum
import com.example.pokedek.Model.Api.Pokemon.Pokeablity.Pokeablty
import com.example.pokedek.Model.Api.Repo.Apirepo
import com.example.pokedek.Model.Api.Pokemon.Pokemonsum.Pokesummary
import com.example.pokedek.Model.Api.Pokemon.Pokemoves.Pokemoves
import com.example.pokedek.Model.Api.Pokemon.pokemonlist.Pokemonlist
import kotlinx.coroutines.launch
import retrofit2.Response

class Apiviewmodel (val repo : Apirepo): ViewModel(){

    val pokelistrespon : MutableLiveData<Response<Pokemonlist>> = MutableLiveData()
    val pokesumrespon : MutableLiveData<Response<Pokesummary>> = MutableLiveData()
    val pokeabtrespon : MutableLiveData<Response<Pokeablty>> = MutableLiveData()
    val pokemovesrespon : MutableLiveData<Response<Pokemoves>> = MutableLiveData()

    val berrylistrespon : MutableLiveData<Response<Berrylist>> = MutableLiveData()
    val berrysumrespon : MutableLiveData<Response<Berrysum>> = MutableLiveData()

    val itemlistrespon : MutableLiveData<Response<Itemlist>> = MutableLiveData()
    val itemsumrespon : MutableLiveData<Response<Itemsum>> = MutableLiveData()

    //pokemon
    fun getpokelist(page: Int,limit: Int){
        viewModelScope.launch {
            pokelistrespon.value = repo.getlist(page, limit)
        }
    }

    fun getpokesum(id : String){
        viewModelScope.launch{
            pokesumrespon.value = repo.getsum(id)
        }
    }
    fun getpokeabt(id: String){
        viewModelScope.launch {
            pokeabtrespon.value = repo.getability(id)
        }
    }
    fun getpokemoves(id: String){
        viewModelScope.launch {
            pokemovesrespon.value = repo.getmoves(id)
        }
    }

    //berry
    fun getberrylist(page: Int,limit: Int){
        viewModelScope.launch {
            berrylistrespon.value = repo.getberrylist(page, limit)
        }
    }

    fun getberrysum(id:String){
        viewModelScope.launch {
            berrysumrespon.value = repo.getberrysum(id)
        }
    }

    //item
    fun getitemlist(page: Int,limit: Int){
        viewModelScope.launch {
            itemlistrespon.value = repo.getitemlist(page, limit)
        }
    }

    fun getitemsum(id: String){
        viewModelScope.launch {
            itemsumrespon.value = repo.getitemsum(id)
        }
    }



}