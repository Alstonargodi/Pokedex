package com.example.ceritaku_compose.repository


import com.example.ceritaku_compose.remote.ApiService.ApiService
import com.example.ceritaku_compose.remote.response.ListPokemonRespon
import com.example.ceritaku_compose.remote.response.SummaryPokemonRespon
import com.example.ceritaku_compose.remote.utils.FetchRespon


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

    suspend fun getPokemonSummary(name : String): FetchRespon<SummaryPokemonRespon>{
        val respon = try {
            apiService.getSummaryPokemon(name)
        }catch (e : Exception){
            return FetchRespon.Error(e.message.toString())
        }
        return if (respon != null){
            FetchRespon.Sucess(respon)
        }else{
            FetchRespon.Loading
        }
    }
}