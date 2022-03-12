package com.example.pokedek.viewmodel.Api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedek.modedl.remote.ApiRepository

class VModelFactory(val repository : ApiRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return Apiviewmodel() as T
    }

}