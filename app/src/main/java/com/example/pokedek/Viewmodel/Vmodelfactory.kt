package com.example.pokedek.Viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedek.Model.Apirepo

class Vmodelfactory(val repo : Apirepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return Viewmodelapi(repo) as T
    }

}