package com.example.pokedek.Model.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokedek.Model.Room.Dao.Pokedao
import com.example.pokedek.Model.Room.Entity.Pokemonlist

/*
Room database
Create Room database with entity that we allready init before
version mean current db version we using
The value of a volatile variable will never be cached,
and all writes and reads will be done to and from the main memory.
This helps make sure the value o
Fallbacktodestructive nee when db migrate to new version
*/


@Database(entities = [Pokemonlist::class], version = 2, exportSchema = false)
abstract class Pokedb : RoomDatabase(){
    abstract fun Pokedao() : Pokedao

    companion object{
        @Volatile
        private var minstance : Pokedb? = null

        fun setdb(context: Context): Pokedb{
            val tempins = minstance
            if (tempins != null){
                return tempins
            }else{
                synchronized(this){
                    val instance = Room.databaseBuilder(context.applicationContext,Pokedb::class.java,"dbpoke")
                        .fallbackToDestructiveMigration().build()
                    minstance = instance
                    return instance
                }
            }
        }

    }
}