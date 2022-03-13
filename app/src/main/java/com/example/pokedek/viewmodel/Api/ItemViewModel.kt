package com.example.pokedek.viewmodel.Api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedek.model.remote.itemresponse.itemlistresponse.Itemlist
import com.example.pokedek.model.remote.itemresponse.itemsumreponse.Itemsum
import com.example.pokedek.model.remote.ApiRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemViewModel : ViewModel(){

    val itemListRespon : MutableLiveData<Response<Itemlist>> = MutableLiveData()
    val itemSumRespon : MutableLiveData<Response<Itemsum>> = MutableLiveData()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    fun getListItem(page: Int, limit: Int){
        _isLoading.value = true
        viewModelScope.launch {
            ApiRepository().getListItem(page, limit).enqueue( object : Callback<Itemlist>{
                override fun onResponse(call: Call<Itemlist>, response: Response<Itemlist>) {
                   if (response.isSuccessful){
                        itemListRespon.value = response
                       _isLoading.value = false
                   }else{
                       Log.d(TAG,response.message())
                       _isLoading.value = false
                   }
                }

                override fun onFailure(call: Call<Itemlist>, t: Throwable) {
                    Log.d(TAG,t.message.toString())
                    _isLoading.value = false
                }
            })
        }
    }

    fun getSummaryItem(name: String){
        _isLoading.value = true
        viewModelScope.launch {
            ApiRepository().getSumItem(name).enqueue(object : Callback<Itemsum>{
                override fun onResponse(call: Call<Itemsum>, response: Response<Itemsum>) {
                    if (response.isSuccessful){
                        itemSumRespon.value = response
                        _isLoading.value = false
                    }else{
                        Log.d(TAG,response.message())
                        _isLoading.value = false
                    }
                }
                override fun onFailure(call: Call<Itemsum>, t: Throwable) {
                    Log.d(TAG,t.message.toString())
                    _isLoading.value = false
                }
            })
        }
    }

    companion object{
        const val TAG = "PokemonViewModel"
    }


}