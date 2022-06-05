package com.example.pokedek.model.repository

import androidx.lifecycle.LiveData
import com.example.pokedek.model.local.dao.Pokedao
import com.example.pokedek.model.local.Entity.Favorite.Favoritelist
import com.example.pokedek.model.local.Entity.Pokemon.PokeSumParcel

/*
 Repo class
 for insert data with entity to db otherwise read data method
 */

class LocalRepository(val dao : Pokedao) {
    val readpoke : LiveData<List<PokeSumParcel>> = dao.readpokelist()
    val readfavbynew : LiveData<List<Favoritelist>> = dao.readfavoritlistbynew()
    val readfavbyold : LiveData<List<Favoritelist>> = dao.readfavoritlistbyold()

    fun readnew(cari : String): LiveData<List<Favoritelist>>{
        return dao.readnew(cari)
    }

    fun readold(cari : String): LiveData<List<Favoritelist>>{
        return dao.readold(cari)
    }


    fun insertpoke(pokelist : PokeSumParcel){
        dao.insertpokelist(pokelist)
    }

    fun insertfavo(favoritelist: Favoritelist){
        dao.insertFavorit(favoritelist)
    }
}