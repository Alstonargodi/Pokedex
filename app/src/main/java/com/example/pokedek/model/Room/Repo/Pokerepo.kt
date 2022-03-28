package com.example.pokedek.model.Room.Repo

import androidx.lifecycle.LiveData
import com.example.pokedek.model.Room.dao.Pokedao
import com.example.pokedek.model.Room.Entity.Favorite.Favoritelist
import com.example.pokedek.model.Room.Entity.Pokemon.PokeSumParcel

/*
 Repo class
 for insert data with entity to db otherwise read data method
 */

class Pokerepo(val dao : Pokedao) {
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