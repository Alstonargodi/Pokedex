package com.example.pokedek.model.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedek.model.local.entity.favorite.Favoritelist
import com.example.pokedek.model.local.entity.pokemon.PokemonFavorite

@Dao
interface LocalDao {
    //entity for paging
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPokemonList(PokemonFavorite : PokemonFavorite)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoritePokemon(favoritelist: Favoritelist)



    //read data favorit
    @Query("select*from PokemonFavoriteTable order by name asc")
    fun readPokemonList(): LiveData<List<PokemonFavorite>>

    @Query("select*from tabelfavorit order by number asc") //terkecil
    fun readFavoriteByAsc() : LiveData<List<Favoritelist>>

    @Query("select*from tabelfavorit order by number desc") //terbesar
    fun readFavoriteByDesc() : LiveData<List<Favoritelist>>

    @Query("select*from tabelfavorit where type like :cari order by number asc")//read by tipe
    fun readTypeByAsc(cari : String): LiveData<List<Favoritelist>>

    @Query("select*from tabelfavorit where type like :cari order by number desc")//read by tipe
    fun readTypeByDesc(cari : String): LiveData<List<Favoritelist>>
}