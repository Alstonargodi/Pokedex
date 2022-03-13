package com.example.pokedek.viewmodel.Api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedek.model.remote.itemresponse.itemlistresponse.Itemlist
import com.example.pokedek.model.remote.itemresponse.itemsumreponse.Itemsum
import com.example.pokedek.model.remote.ApiRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ItemViewModel : ViewModel(){

    val itemListRespon : MutableLiveData<Response<Itemlist>> = MutableLiveData()
    val itemSumRespon : MutableLiveData<Response<Itemsum>> = MutableLiveData()


    fun getListItem(page: Int, limit: Int){
        viewModelScope.launch {
            itemListRespon.value = ApiRepository().getListItem(page, limit)
        }
    }

    fun getSummaryItem(id: String){
        viewModelScope.launch {
            itemSumRespon.value = ApiRepository().getSumItem(id)
        }
    }



}