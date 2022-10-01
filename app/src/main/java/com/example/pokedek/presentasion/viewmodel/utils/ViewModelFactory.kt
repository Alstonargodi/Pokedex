

package com.example.pokedek.presentasion.viewmodel.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedek.model.injection.Injection
import com.example.pokedek.repository.RemoteRepository
import com.example.pokedek.presentasion.viewmodel.remote.PokemonViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory private constructor(private val repository : RemoteRepository):
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonViewModel::class.java)){
            return PokemonViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object{
        @Volatile
        private var instance : ViewModelFactory? = null
        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this){
                instance ?: ViewModelFactory(Injection.provideRepository())
            }.also { instance = it }
    }
}