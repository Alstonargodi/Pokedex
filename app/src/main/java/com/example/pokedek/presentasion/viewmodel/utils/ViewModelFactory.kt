

package com.example.pokedek.presentasion.viewmodel.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedek.model.injection.Injection
import com.example.pokedek.presentasion.fragment.pokemon.viewmodel.PokemonDetailViewModel
import com.example.pokedek.presentasion.fragment.pokemon.viewmodel.PokemonHomeViewModel
import com.example.pokedek.repository.RemoteRepository
import com.example.pokedek.presentasion.viewmodel.remote.PokemonViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory private constructor(private val repository : RemoteRepository):
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonViewModel::class.java)){
            return PokemonViewModel(repository) as T
        }else if(modelClass.isAssignableFrom(PokemonHomeViewModel::class.java)){
            return PokemonHomeViewModel(repository) as T
        }else if(modelClass.isAssignableFrom(PokemonDetailViewModel::class.java)){
            return PokemonDetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object{
        @Volatile
        private var instance : ViewModelFactory? = null
        fun getInstance(context : Context): ViewModelFactory =
            instance ?: synchronized(this){
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }.also { instance = it }
    }
}