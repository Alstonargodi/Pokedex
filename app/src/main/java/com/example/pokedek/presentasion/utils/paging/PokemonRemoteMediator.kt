package com.example.pokedek.presentasion.utils.paging

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.pokedek.model.local.mediator.database.MediatorDatabase
import com.example.pokedek.model.local.mediator.pokemon.PokemonMediatorList
import com.example.pokedek.model.local.mediator.remotekey.RemoteKeys
import com.example.pokedek.model.remote.apiservice.ApiService
import com.example.pokedek.model.remote.response.itemresponse.itemsummaryresponse.Pokemon
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonlistresponse.PokemonListResult

@OptIn(ExperimentalPagingApi::class)
class PokemonRemoteMediator(
    private val database : MediatorDatabase,
    private val apiService : ApiService,
): RemoteMediator<Int, PokemonListResult>() {

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PokemonListResult>
    ): MediatorResult {
        val page = when(loadType){
            LoadType.REFRESH->{
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextKey?.minus(1) ?: initial_page
            }
            LoadType.PREPEND -> {
                val remoteKeys = getRemoteKeyForFirstItem(state)
                val prevKey = remoteKeys?.prevKey
                    ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null)
                prevKey
            }

            LoadType.APPEND -> {
                val remoteKeys = getRemoteForLastItem(state)
                val nextKey = remoteKeys?.nextKey
                    ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null)
                nextKey
            }
        }

        try{
            val responseData = apiService.getListPokemon(
                page,
                state.config.pageSize
            ).results
            val endPagination = responseData.isEmpty()

            database.withTransaction {
                if(loadType == LoadType.REFRESH){
                    database.RemoteKeyDao().deleteRemoteKeys()
                    database.pokemonMediatorDao().deletePokemonMediatorList()
                }
                val prevKey = if (page == 1) null else page - 1
                val nextKey = if (endPagination) null else page + 1
                val keys = responseData.map {
                    RemoteKeys(id = it.id, prevKey = prevKey, nextKey = nextKey)
                }
                database.RemoteKeyDao().insertAllKeys(keys)
                database.pokemonMediatorDao().insertPokemonMediatorList(responseData)
            }
            return MediatorResult.Success(endOfPaginationReached = endPagination)
        }catch (e : Exception){
            return MediatorResult.Error(e)
        }

    }

    private suspend fun getRemoteForLastItem(state: PagingState<Int, PokemonListResult>): RemoteKeys?{
        return state.pages.lastOrNull {
            it.data.isEmpty() }?.data?.lastOrNull()?.let { data ->
            database.RemoteKeyDao().getRemoteKeysId(data.id.toString())
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, PokemonListResult>): RemoteKeys? {
        return state.pages.firstOrNull {
            it.data.isNotEmpty() }?.data?.firstOrNull()?.let { data ->
            database.RemoteKeyDao().getRemoteKeysId(data.id.toString())
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, PokemonListResult>): RemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                database.RemoteKeyDao().getRemoteKeysId(id.toString())
            }
        }
    }

    private companion object{
        const val initial_page = 1
    }


}