package com.example.pokedek.Viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedek.Model.Api.Berry.BerryList.Berrylist
import com.example.pokedek.Model.Api.Pokemon.Pokeablity.Pokeablty
import com.example.pokedek.Model.Api.Repo.Apirepo
import com.example.pokedek.Model.Api.Pokemon.Pokemonsum.Pokesummary
import com.example.pokedek.Model.Api.Pokemon.pokemonlist.Pokemonlist
import kotlinx.coroutines.launch
import retrofit2.Response

class Apiviewmodel (val repo : Apirepo): ViewModel(){

    val pokelistrespon : MutableLiveData<Response<Pokemonlist>> = MutableLiveData()
    val pokesumrespon : MutableLiveData<Response<Pokesummary>> = MutableLiveData()
    val pokeabtrespon : MutableLiveData<Response<Pokeablty>> = MutableLiveData()

    val berrylistrespon : MutableLiveData<Response<Berrylist>> = MutableLiveData()


    //pokemon
    fun getpokelist(){
        viewModelScope.launch {
            pokelistrespon.value = repo.getlist()
        }
    }
    fun getpokesum(id : String){
        viewModelScope.launch{
            val data = repo.getsum(id)
            pokesumrespon.value = data
        }
    }
    fun getpokeabt(id: String){
        viewModelScope.launch {
            val datadua = repo.getability(id)
            pokeabtrespon.value = datadua
        }
    }

    //berry
    fun getberrylist(){
        viewModelScope.launch {
            berrylistrespon.value = repo.getberrylist()
        }
    }




}