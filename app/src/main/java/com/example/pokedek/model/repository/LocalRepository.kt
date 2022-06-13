package com.example.pokedek.model.repository

import androidx.lifecycle.LiveData
import com.example.pokedek.model.local.dao.LocalDao
import com.example.pokedek.model.local.entity.Favorite.Favoritelist
import com.example.pokedek.model.local.entity.pokemon.PokemonFavorite

/*
 Repo class
 for insert data with entity to db otherwise read data method
 */

class LocalRepository(val dao : LocalDao) {
    val readpoke : LiveData<List<PokemonFavorite>> = dao.readpokelist()
    val readfavbynew : LiveData<List<Favoritelist>> = dao.readfavoritlistbynew()
    val readfavbyold : LiveData<List<Favoritelist>> = dao.readfavoritlistbyold()

    fun readnew(cari : String): LiveData<List<Favoritelist>>{
        return dao.readnew(cari)
    }

    fun readold(cari : String): LiveData<List<Favoritelist>>{
        return dao.readold(cari)
    }


    fun insertpoke(pokelist : PokemonFavorite){
        dao.insertpokelist(pokelist)
    }

    fun insertfavo(favoritelist: Favoritelist){
        dao.insertFavorit(favoritelist)
    }
}