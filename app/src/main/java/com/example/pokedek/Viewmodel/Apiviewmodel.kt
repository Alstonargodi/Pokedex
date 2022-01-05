package com.example.pokedek.Viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedek.Model.Api.Repo.Apirepo
import com.example.pokedek.Model.Api.Pokemonsum.Pokesummary
import com.example.pokedek.Model.Api.pokemonlist.Pokemon
import kotlinx.coroutines.launch
import retrofit2.Response

class Apiviewmodel (val repo : Apirepo): ViewModel(){
    val listapirespon : MutableLiveData<Response<Pokemon>> = MutableLiveData()
    val sumapirespon : MutableLiveData<Response<Pokesummary>> = MutableLiveData()

    fun getdata(id : String){
        viewModelScope.launch{
            val data = repo.getsum(id)
            sumapirespon.value = data
        }
    }

    fun getlist(){
        viewModelScope.launch {
            val data = repo.getlist()
            listapirespon.value = data
        }
    }

}