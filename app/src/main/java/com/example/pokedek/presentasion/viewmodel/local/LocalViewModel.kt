package com.example.pokedek.presentasion.viewmodel.local

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedek.model.local.entity.pokemon.PokemonFavorite
import com.example.pokedek.model.local.databaseconfig.DatabaseConfig
import com.example.pokedek.model.local.entity.Favorite.Favoritelist
import com.example.pokedek.repository.LocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocalViewModel(application: Application): AndroidViewModel(application) {
    val LocalRepository : LocalRepository
    val readpokelist : LiveData<List<PokemonFavorite>>
    val readfavlistbynew : LiveData<List<Favoritelist>>
    val readfavlistbyold : LiveData<List<Favoritelist>>

    init {
        val pokedao = DatabaseConfig.setDatabase(application).LocalDao()
        LocalRepository = LocalRepository(pokedao)
        readpokelist = LocalRepository.readpoke
        readfavlistbynew = LocalRepository.readfavbynew
        readfavlistbyold = LocalRepository.readfavbyold
    }





    fun readnew(cari : String): LiveData<List<Favoritelist>>{
        return LocalRepository.readnew(cari)
    }

    fun readold(cari : String): LiveData<List<Favoritelist>>{
        return LocalRepository.readold(cari)
    }

    fun insertfav(favoritelist: Favoritelist){
        viewModelScope.launch(Dispatchers.IO) {
            LocalRepository.insertfavo(favoritelist)
        }
    }

}
