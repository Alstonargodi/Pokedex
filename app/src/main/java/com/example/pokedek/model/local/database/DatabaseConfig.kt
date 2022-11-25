package com.example.pokedek.model.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokedek.model.local.dao.LocalDao
import com.example.pokedek.model.local.entity.favorite.FavoriteData
import com.example.pokedek.model.local.entity.favorite.Favoritelist
import com.example.pokedek.model.local.entity.pokemon.PokemonFavorite
import com.example.pokedek.model.local.mediator.database.MediatorDatabase

/*
Room database
Create Room database with entity that we allready init before
version mean current db version we using
The value of a volatile variable will never be cached,
and all writes and reads will be done to and from the main memory.
This helps make sure the value o
Fallbacktodestructive nee when db migrate to new version
*/

@Database(entities = [
    FavoriteData::class,
    PokemonFavorite::class,
    Favoritelist::class],
    version = 1,
    exportSchema = false
)
abstract class DatabaseConfig : RoomDatabase(){
    abstract fun LocalDao() : LocalDao

    companion object{
        @Volatile
        private var INSTANCE : DatabaseConfig? = null

        @JvmStatic
        fun setDatabase(context: Context): DatabaseConfig {
            return INSTANCE ?: synchronized(this){
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseConfig::class.java,"FavoritePokemonDB"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }

    }
}