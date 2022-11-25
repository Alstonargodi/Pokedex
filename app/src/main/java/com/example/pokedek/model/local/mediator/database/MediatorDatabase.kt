package com.example.pokedek.model.local.mediator.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokedek.model.local.mediator.pokemon.PokemonMediatorDao
import com.example.pokedek.model.local.mediator.pokemon.PokemonMediatorList
import com.example.pokedek.model.local.mediator.remotekey.RemoteKeyDao
import com.example.pokedek.model.local.mediator.remotekey.RemoteKeys
import com.example.pokedek.model.remote.response.pokemonreponse.pokemonlistresponse.PokemonListResult

@Database(
    entities = [
        PokemonListResult::class,
        RemoteKeys::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MediatorDatabase: RoomDatabase() {
    abstract fun pokemonMediatorDao(): PokemonMediatorDao
    abstract fun RemoteKeyDao() : RemoteKeyDao

    companion object{
        @Volatile
        private var INSTANCE : MediatorDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): MediatorDatabase{
            return INSTANCE ?: synchronized(this){
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    MediatorDatabase::class.java,"PokemonMediatorDB"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}