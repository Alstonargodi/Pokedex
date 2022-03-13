package com.example.pokedek.model.Room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedek.model.Room.Entity.Favorite.Favoritelist
import com.example.pokedek.model.Room.Entity.Pokemon.PokemonSummary

 /*
 Dao
 Insert list of pokemon to local storage
  */

@Dao
abstract class Pokedao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertpokelist(PokemonSummary : PokemonSummary)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertFavorit(favoritelist: Favoritelist)

    //read data favorit
    @Query("select*from pokemonlist order by name asc")
    abstract fun readpokelist(): LiveData<List<PokemonSummary>>


    @Query("select*from tabelfavorit order by number asc") //terkecil
    abstract fun readfavoritlistbyold() : LiveData<List<Favoritelist>>

    @Query("select*from tabelfavorit order by number desc") //terbesar
    abstract fun readfavoritlistbynew() : LiveData<List<Favoritelist>>

    @Query("select*from tabelfavorit where type like :cari order by number desc")//read by tipe
    abstract fun readnew(cari : String): LiveData<List<Favoritelist>>

    @Query("select*from tabelfavorit where type like :cari order by number desc")//read by tipe
    abstract fun readold(cari : String): LiveData<List<Favoritelist>>




}