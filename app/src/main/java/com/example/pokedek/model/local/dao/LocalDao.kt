package com.example.pokedek.model.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedek.model.local.entity.Favorite.Favoritelist
import com.example.pokedek.model.local.entity.pokemon.PokemonFavorite


@Dao
interface LocalDao {


    //paging




    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertpokelist(PokemonFavorite : PokemonFavorite)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorit(favoritelist: Favoritelist)

    //read data favorit
    @Query("select*from PokemonFavoriteTable order by name asc")
    fun readpokelist(): LiveData<List<PokemonFavorite>>


    @Query("select*from tabelfavorit order by number asc") //terkecil
    fun readfavoritlistbyold() : LiveData<List<Favoritelist>>

    @Query("select*from tabelfavorit order by number desc") //terbesar
    fun readfavoritlistbynew() : LiveData<List<Favoritelist>>

    @Query("select*from tabelfavorit where type like :cari order by number desc")//read by tipe
    fun readnew(cari : String): LiveData<List<Favoritelist>>

    @Query("select*from tabelfavorit where type like :cari order by number desc")//read by tipe
    fun readold(cari : String): LiveData<List<Favoritelist>>




}