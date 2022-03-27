

package com.example.pokedek.viewmodel.Api

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedek.model.Injection
import com.example.pokedek.model.remote.ApiRepository

class VModelFactory private constructor(private val repository : ApiRepository):
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