package com.example.ceritaku_compose.presentasion.mainactivity

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.example.ceritaku_compose.remote.response.ListPokemonRespon
import com.example.ceritaku_compose.remote.response.PokemonListResult
import com.example.ceritaku_compose.remote.response.SummaryPokemonRespon
import com.example.ceritaku_compose.remote.utils.FetchRespon
import com.example.ceritaku_compose.repository.RemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val remoteRepository: RemoteRepository
): ViewModel(){

    var pokemonList = mutableStateOf<List<PokemonListResult>>(listOf())
    var isLoading = mutableStateOf(false)
    var isError = mutableStateOf("")

    init {
        getPokemonList()
    }

    private fun getPokemonList(){
        viewModelScope.launch {
            remoteRepository.getPokemonList().also {
                when(it){
                    is FetchRespon.Loading->{
                        isLoading.value = true
                    }
                    is FetchRespon.Sucess->{
                        isLoading.value = false
                        pokemonList.value = it.data.results
                    }
                    is FetchRespon.Error->{
                        isLoading.value = false
                        isError.value = it.error
                    }
                    else -> {}
                }
            }
        }
    }

    suspend fun getPokemonSummary(name : String): FetchRespon<SummaryPokemonRespon>{
        return remoteRepository.getPokemonSummary(name)
    }
}