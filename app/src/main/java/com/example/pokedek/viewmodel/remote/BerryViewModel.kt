package com.example.pokedek.viewmodel.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedek.model.remote.response.berryresponse.berrylistresponse.BerryListResponse
import com.example.pokedek.model.remote.response.berryresponse.berrysummaryresponse.BerrySummaryResponse
import retrofit2.Response

class BerryViewModel: ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    val berryListRespon : MutableLiveData<Response<BerryListResponse>> = MutableLiveData()
    val berrySummaryRespon : MutableLiveData<Response<BerrySummaryResponse>> = MutableLiveData()

    //berry
//    fun getListBerry(page: Int, limit: Int){
//        _isLoading.value = true
//        viewModelScope.launch {
//            RemoteRepository().getListBerry(page, limit).enqueue(object : Callback<BerryListResponse>{
//                override fun onResponse(
//                    call: Call<BerryListResponse>,
//                    response: Response<BerryListResponse>
//                ) {
//                   if (response.isSuccessful){
//                       berryListRespon.value = response
//                       _isLoading.value = false
//                   }else{
//                       Log.d(TAG,response.message())
//                       _isLoading.value = false
//                   }
//                }
//
//                override fun onFailure(call: Call<BerryListResponse>, t: Throwable) {
//                    Log.d(TAG,t.message.toString())
//                    _isLoading.value = false
//                }
//
//            })
//        }
//    }
//
//    fun getSumBerry(name:String){
//        _isLoading.value = true
//        viewModelScope.launch {
//            RemoteRepository().getSumBerry(name).enqueue(object : Callback<BerrySummaryResponse> {
//                override fun onResponse(
//                    call: Call<BerrySummaryResponse>,
//                    response: Response<BerrySummaryResponse>
//                ) {
//                    if (response.isSuccessful){
//                        berrySummaryRespon.value = response
//                        _isLoading.value = false
//                    }else{
//                        Log.d(TAG,response.message())
//                    }
//                }
//
//                override fun onFailure(call: Call<BerrySummaryResponse>, t: Throwable) {
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