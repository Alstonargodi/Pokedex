

package com.example.pokedek.viewmodel.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedek.model.injection.Injection
import com.example.pokedek.model.repository.RemoteRepository
import com.example.pokedek.viewmodel.remote.PokemonViewModel

@Suppress("UNCHECKED_CAST")
class VModelFactory private constructor(private val repository : RemoteRepository):
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonViewModel::class.java)){
            return PokemonViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object{
        @Volatile
        private var instance : VModelFactory? = null
        fun getInstance(): VModelFactory =
            instance ?: synchronized(this){
                instance ?: VModelFactory(Injection.provideRepository())
            }.also { instance = it }
    }
}