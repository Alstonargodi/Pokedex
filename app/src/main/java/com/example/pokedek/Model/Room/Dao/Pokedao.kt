package com.example.pokedek.Model.Room.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.pokedek.Model.Room.Entity.Pokemonlist

 /*
 Dao
 Insert list of pokemon to local storage
  */

@Dao
abstract class Pokedao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertpokelist(Pokemonlist : Pokemonlist)

    @Query("select*from pokemonlist")
    abstract fun readpokelist(): LiveData<List<Pokemonlist>>
}