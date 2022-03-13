package com.example.pokedek.viewmodel.Api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedek.model.remote.berryresponse.berrylistresponse.BerryListResponse
import com.example.pokedek.model.remote.berryresponse.berrysumresponse.BerrySumResponse
import com.example.pokedek.model.remote.itemresponse.itemlistresponse.Itemlist
import com.example.pokedek.model.remote.itemresponse.itemsumreponse.Itemsum
import com.example.pokedek.model.remote.pokemonreponse.pokemonabilityresponse.Pokeablty
import com.example.pokedek.model.remote.ApiRepository
import com.example.pokedek.model.remote.pokemonreponse.Pokemonsum.Pokesummary
import com.example.pokedek.model.remote.pokemonreponse.Pokemoves.Pokemoves
import com.example.pokedek.model.remote.pokemonreponse.pokemonlist.Pokemonlist
import kotlinx.coroutines.launch
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