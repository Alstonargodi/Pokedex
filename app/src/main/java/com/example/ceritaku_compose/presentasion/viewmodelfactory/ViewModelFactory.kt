package com.example.ceritaku_compose.presentasion.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ceritaku_compose.injection.Injection
import com.example.ceritaku_compose.presentasion.home.viewmodel.HomeActivityViewModel
import com.example.ceritaku_compose.repository.RemoteRepository

class ViewModelFactory (
    private val repository: RemoteRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       if (modelClass.isAssignableFrom(HomeActivityViewModel::class.java)){
           return HomeActivityViewModel(repository) as T
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