package com.example.pokedek.model.local.mediator.pokemon

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonlistresponse.PokemonListResult

@Dao
interface PokemonMediatorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonMediatorList(pokemon : List<PokemonMediatorList>)

    @Query("select * from TablePokemonMediator")
    fun getAllPokemonMediatorList(): PagingSource<Int,PokemonListResult>

    @Query("delete from TablePokemonMediator")
    suspend fun deletePokemonMediatorList()
}