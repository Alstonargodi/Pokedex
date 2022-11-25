package com.example.pokedek.presentasion.viewmodel.local

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedek.model.local.entity.pokemon.PokemonFavorite
import com.example.pokedek.model.local.database.DatabaseConfig
import com.example.pokedek.model.local.entity.favorite.Favoritelist
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
        readpokelist = LocalRepository.favoritePokemon
        readfavlistbynew = LocalRepository.readFavoriteByDesc
        readfavlistbyold = LocalRepository.readFavoriteByAsc
    }


    fun readnew(cari : String): LiveData<List<Favoritelist>>{
        return LocalRepository.readTypeByAsc(cari)
    }

    fun readold(cari : String): LiveData<List<Favoritelist>>{
        return LocalRepository.readTypeByDesc(cari)
    }

    fun insertfav(favoritelist: Favoritelist){
        viewModelScope.launch(Dispatchers.IO) {
            LocalRepository.insertFavoritePokemon(favoritelist)
        }
    }

}
