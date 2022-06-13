package com.example.pokedek.model.remote.utils

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pokedek.model.remote.apiservice.ApiService
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonlistresponse.PokemonListRespon
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonlistresponse.PokemonListResult
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonsummaryresponse.PokemonSummaryResponse

class RemotePaging(private val apiService: ApiService): PagingSource<Int,
        PokemonListResult>() {
    override fun getRefreshKey(state: PagingState<Int,
            PokemonListResult>): Int? {
       return state.anchorPosition?.let { position->
           val anchorPage = state.closestPageToPosition(position)
           anchorPage?.prevKey?.plus(1) ?:
           anchorPage?.nextKey?.minus(1)
       }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int,
            PokemonListResult> {
       return try {
            val position = params.key ?: initial_index
           val responData = apiService.getListPokemon(position,params.loadSize)
           Log.d("paging test",responData.results.toString())
           LoadResult.Page(
               data = responData.results,
               prevKey = if (position == initial_index) null else position - 1,
               nextKey = if (responData.results.isNullOrEmpty()) null else position + 1
           )
       } catch (e : Exception){
           return LoadResult.Error(e)
       }
    }

    private companion object{
        const val initial_index = 1
    }
}