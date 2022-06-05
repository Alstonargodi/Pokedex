package com.example.pokedek.model.injection

import com.example.pokedek.model.remote.ApiConfig
import com.example.pokedek.model.repository.RemoteRepository

object Injection {
    fun provideRepository(): RemoteRepository {
        return RemoteRepository(ApiConfig.getApiService())
    }
}