package com.example.pokedek.viewmodel.Api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedek.model.remote.ApiRepository
import com.example.pokedek.model.remote.berryresponse.berrylistresponse.BerryListResponse
import com.example.pokedek.model.remote.berryresponse.berrysumresponse.BerrySumResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BerryViewModel: ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    val berryListRespon : MutableLiveData<Response<BerryListResponse>> = MutableLiveData()
    val berrySumRespon : MutableLiveData<Response<BerrySumResponse>> = MutableLiveData()

    //berry
//    fun getListBerry(page: Int, limit: Int){
//        _isLoading.value = true
//        viewModelScope.launch {
//            ApiRepository().getListBerry(page, limit).enqueue(object : Callback<BerryListResponse>{
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
//            ApiRepository().getSumBerry(name).enqueue(object : Callback<BerrySumResponse> {
//                override fun onResponse(
//                    call: Call<BerrySumResponse>,
//                    response: Response<BerrySumResponse>
//                ) {
//                    if (response.isSuccessful){
//                        berrySumRespon.value = response
//                        _isLoading.value = false
//                    }else{
//                        Log.d(TAG,response.message())
//                    }
//                }
//
//                override fun onFailure(call: Call<BerrySumResponse>, t: Throwable) {
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