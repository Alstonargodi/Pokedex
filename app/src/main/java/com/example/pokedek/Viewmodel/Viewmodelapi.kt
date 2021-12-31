package com.example.pokedek.Viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedek.Model.Apirepo
import com.example.pokedek.Model.Pokemonsum.Pokesummary
import com.example.pokedek.Model.pokemonlist.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class Viewmodelapi (val repo : Apirepo): ViewModel(){
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