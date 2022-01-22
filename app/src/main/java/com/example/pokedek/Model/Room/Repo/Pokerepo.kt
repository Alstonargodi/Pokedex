package com.example.pokedek.Model.Room.Repo

import androidx.lifecycle.LiveData
import com.example.pokedek.Model.Room.Dao.Pokedao
import com.example.pokedek.Model.Room.Entity.Favorite.Favoritelist
import com.example.pokedek.Model.Room.Entity.Pokemon.Pokemonlist

/*
 Repo class
 for insert data with entity to db otherwise read data method
 */

class Pokerepo(val dao : Pokedao) {
    val readpoke : LiveData<List<Pokemonlist>> = dao.readpokelist()
    val readfav : LiveData<List<Favoritelist>> = dao.readfavoritlist()

    fun insertpoke(pokelist : Pokemonlist){
        dao.insertpokelist(pokelist)
    }

    fun insertfavo(favoritelist: Favoritelist){
        dao.insertFavorit(favoritelist)
    }
}