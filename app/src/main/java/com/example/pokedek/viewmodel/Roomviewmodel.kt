package com.example.pokedek.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedek.model.Room.Entity.Pokemon.PokeSumParcel
import com.example.pokedek.model.Room.Database.Pokedb
import com.example.pokedek.model.Room.Entity.Favorite.Favoritelist
import com.example.pokedek.model.Room.Repo.Pokerepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Roomviewmodel(application: Application): AndroidViewModel(application) {
    val Pokerepo : Pokerepo
    val readpokelist : LiveData<List<PokeSumParcel>>
    val readfavlistbynew : LiveData<List<Favoritelist>>
    val readfavlistbyold : LiveData<List<Favoritelist>>

    init {
        val pokedao = Pokedb.setdb(application).Pokedao()
        Pokerepo = Pokerepo(pokedao)
        readpokelist = Pokerepo.readpoke
        readfavlistbynew = Pokerepo.readfavbynew
        readfavlistbyold = Pokerepo.readfavbyold
    }





    fun readnew(cari : String): LiveData<List<Favoritelist>>{
        return Pokerepo.readnew(cari)
    }

    fun readold(cari : String): LiveData<List<Favoritelist>>{
        return Pokerepo.readold(cari)
    }

    fun insertfav(favoritelist: Favoritelist){
        viewModelScope.launch(Dispatchers.IO) {
            Pokerepo.insertfavo(favoritelist)
        }
    }

}
