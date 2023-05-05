package com.example.ceritaku_compose.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.liveData
import com.example.ceritaku_compose.remote.ApiService.ApiService
import com.example.ceritaku_compose.remote.response.ListPokemonRespon
import com.example.ceritaku_compose.remote.response.SummaryPokemonRespon
import com.example.ceritaku_compose.remote.utils.FetchRespon
import java.lang.Exception

class RemoteRepository(
    private val apiService : ApiService,
) {
    suspend fun getPokemonList(): FetchRespon<ListPokemonRespon> {
        val respon  =
            try {
                apiService.getListPokemon(0,1000)
            }catch (e : Exception){
                return FetchRespon.Error(e.message.toString())
            }
        return FetchRespon.Sucess(respon)
    }

    suspend fun getPokemonSummary(name : String): LiveData<FetchRespon<SummaryPokemonRespon>>{
        return liveData {
            emit(FetchRespon.Loading)
            try{
                val data = apiService.getSummaryPokemon(name)
                emit(FetchRespon.Sucess(data))
            }catch (e : Exception){
                emit(FetchRespon.Error(e.message.toString()))
            }
        }
    }
}