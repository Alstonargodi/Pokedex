package com.example.pokedek.modedl.Room.Repo

import androidx.lifecycle.LiveData
import com.example.pokedek.modedl.Room.Dao.Pokedao
import com.example.pokedek.modedl.Room.Entity.Favorite.Favoritelist
import com.example.pokedek.modedl.Room.Entity.Pokemon.Pokemonlist

/*
 Repo class
 for insert data with entity to db otherwise read data method
 */

class Pokerepo(val dao : Pokedao) {
    val readpoke : LiveData<List<Pokemonlist>> = dao.readpokelist()
    val readfavbynew : LiveData<List<Favoritelist>> = dao.readfavoritlistbynew()
    val readfavbyold : LiveData<List<Favoritelist>> = dao.readfavoritlistbyold()

    fun readnew(cari : String): LiveData<List<Favoritelist>>{
        return dao.readnew(cari)
    }

    fun readold(cari : String): LiveData<List<Favoritelist>>{
        return dao.readold(cari)
    }


    fun insertpoke(pokelist : Pokemonlist){
        dao.insertpokelist(pokelist)
    }

    fun insertfavo(favoritelist: Favoritelist){
        dao.insertFavorit(favoritelist)
    }
}