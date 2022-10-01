package com.example.pokedek.presentasion.viewmodel.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedek.model.remote.response.itemresponse.itemlistresponse.Itemlist
import com.example.pokedek.model.remote.response.itemresponse.itemsummaryresponse.ItemSummaryResponse
import retrofit2.Response

class ItemViewModel : ViewModel(){

    val itemListRespon : MutableLiveData<Response<Itemlist>> = MutableLiveData()
    val itemSumRespon : MutableLiveData<Response<ItemSummaryResponse>> = MutableLiveData()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

//    fun getListItem(page: Int, limit: Int){
//        _isLoading.value = true
//        viewModelScope.launch {
//            RemoteRepository().getListItem(page, limit).enqueue( object : Callback<Itemlist>{
//                override fun onResponse(call: Call<Itemlist>, response: Response<Itemlist>) {
//                   if (response.isSuccessful){
//                        itemListRespon.value = response
//                       _isLoading.value = false
//                   }else{
//                       Log.d(TAG,response.message())
//                       _isLoading.value = false
//                   }
//                }
//
//                override fun onFailure(call: Call<Itemlist>, t: Throwable) {
//                    Log.d(TAG,t.message.toString())
//                    _isLoading.value = false
//                }
//            })
//        }
//    }
//
//    fun getSummaryItem(name: String){
//        _isLoading.value = true
//        viewModelScope.launch {
//            RemoteRepository().getSumItem(name).enqueue(object : Callback<ItemSummaryResponse>{
//                override fun onResponse(call: Call<ItemSummaryResponse>, response: Response<ItemSummaryResponse>) {
//                    if (response.isSuccessful){
//                        itemSumRespon.value = response
//                        _isLoading.value = false
//                    }else{
//                        Log.d(TAG,response.message())
//                        _isLoading.value = false
//                    }
//                }
//                override fun onFailure(call: Call<ItemSummaryResponse>, t: Throwable) {
//                    Log.d(TAG,t.message.toString())
//                    _isLoading.value = false
//                }
//            })
//        }
//    }

    companion object{
        const val TAG = "PokemonViewModel"
    }


}