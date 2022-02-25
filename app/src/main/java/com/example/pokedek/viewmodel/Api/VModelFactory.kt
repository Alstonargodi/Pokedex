package com.example.pokedek.viewmodel.Api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedek.modedl.Api.Repo.ApiRepo

class VModelFactory(val repo : ApiRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return Apiviewmodel(repo) as T
    }

}