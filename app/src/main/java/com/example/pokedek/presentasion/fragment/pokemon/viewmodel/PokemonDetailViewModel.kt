package com.example.pokedek.presentasion.fragment.pokemon.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonsummaryresponse.PokemonSummaryResponse
import com.example.pokedek.model.remote.utils.Fetchstatus
import com.example.pokedek.repository.RemoteRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonDetailViewModel(
    private val repository: RemoteRepository
) : ViewModel(){
    val pokesumrespon = MutableLiveData<Response<PokemonSummaryResponse>>()

    suspend fun getPokemonSummary(name : String): LiveData<Fetchstatus<PokemonSummaryResponse>>{
       return repository.getSummaryPokemon(name)
    }
}