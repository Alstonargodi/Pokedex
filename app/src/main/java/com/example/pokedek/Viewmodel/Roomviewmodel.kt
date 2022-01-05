package com.example.pokedek.Viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedek.Model.Room.Entity.Pokemonlist
import com.example.pokedek.Model.Room.Pokedb
import com.example.pokedek.Model.Room.Repo.Pokerepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Roomviewmodel(application: Application): AndroidViewModel(application) {
    val Pokerepo : Pokerepo
    val readpokelist : LiveData<List<Pokemonlist>>

    init {
        val pokedao = Pokedb.setdb(application).Pokedao()
        Pokerepo = Pokerepo(pokedao)
        readpokelist = Pokerepo.readpoke
    }

    fun insertpoke(pokemonlist: Pokemonlist){
        viewModelScope.launch(Dispatchers.IO) {
            Pokerepo.insertpoke(pokemonlist)
        }
    }

}
