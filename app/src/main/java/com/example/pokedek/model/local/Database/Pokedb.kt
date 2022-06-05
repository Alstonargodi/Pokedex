package com.example.pokedek.model.local.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokedek.model.local.dao.Pokedao
import com.example.pokedek.model.local.Entity.Favorite.Favoritelist
import com.example.pokedek.model.local.Entity.Pokemon.PokeSumParcel

/*
Room database
Create Room database with entity that we allready init before
version mean current db version we using
The value of a volatile variable will never be cached,
and all writes and reads will be done to and from the main memory.
This helps make sure the value o
Fallbacktodestructive nee when db migrate to new version
*/

@Database(entities = [PokeSumParcel::class,Favoritelist::class], version = 21, exportSchema = false)
abstract class Pokedb : RoomDatabase(){
    abstract fun Pokedao() : Pokedao

    companion object{
        @Volatile
        private var minstance : Pokedb? = null

        fun setdb(context: Context): Pokedb {
            val tempins = minstance
            if (tempins != null){
                return tempins
            }else{
                synchronized(this){
                    val instance = Room.databaseBuilder(context.applicationContext,
                        Pokedb::class.java,"dbpoke").fallbackToDestructiveMigration().build()
                    minstance = instance
                    return instance
                }
            }
        }

    }
}