package com.example.pokedek.model.local.databaseconfig

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokedek.model.local.dao.LocalDao
import com.example.pokedek.model.local.entity.Favorite.Favoritelist
import com.example.pokedek.model.local.entity.pokemon.PokemonFavorite

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
    PokemonFavorite::class,
    Favoritelist::class],
    version = 25,
    exportSchema = false
)
abstract class DatabaseConfig : RoomDatabase(){
    abstract fun LocalDao() : LocalDao

    companion object{
        @Volatile
        private var INSTANCE : DatabaseConfig? = null

        fun setDatabase(context: Context): DatabaseConfig {
            val mInstance = INSTANCE
            if (mInstance != null){
                return mInstance
            }else{
                synchronized(this){
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseConfig::class.java,
                        "dbtest")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                    return instance
                }
            }
        }

    }
}