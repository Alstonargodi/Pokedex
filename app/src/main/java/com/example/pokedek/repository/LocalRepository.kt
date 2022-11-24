package com.example.pokedek.repository

import androidx.lifecycle.LiveData
import com.example.pokedek.model.local.dao.LocalDao
import com.example.pokedek.model.local.entity.favorite.Favoritelist
import com.example.pokedek.model.local.entity.pokemon.PokemonFavorite

/*
 Repo class
 for insert data with entity to db otherwise read data method
 */
class LocalRepository(private val localDao : LocalDao) {
    val favoritePokemon : LiveData<List<PokemonFavorite>> = localDao.readPokemonList()
    val readFavoriteByDesc : LiveData<List<Favoritelist>> = localDao.readFavoriteByDesc()
    val readFavoriteByAsc : LiveData<List<Favoritelist>> = localDao.readFavoriteByAsc()

    fun readTypeByAsc(cari : String): LiveData<List<Favoritelist>>{
        return localDao.readTypeByAsc(cari)
    }
    fun readTypeByDesc(cari : String): LiveData<List<Favoritelist>>{
        return localDao.readTypeByDesc(cari)
    }

    fun insertFavoritePokemon(favoriteList: Favoritelist){
        localDao.insertFavoritePokemon(favoriteList)
    }
}