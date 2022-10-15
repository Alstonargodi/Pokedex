package com.example.pokedek.presentasion.fragment.pokemon

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonlistresponse.PokemonListResult
import com.example.pokedek.repository.RemoteRepository

class PokemonHomeViewModel(
    private val repository: RemoteRepository
): ViewModel() {

    fun getPagedListPokemon(): LiveData<PagingData<PokemonListResult>> =
        repository.getPokemonList().cachedIn(viewModelScope)
}