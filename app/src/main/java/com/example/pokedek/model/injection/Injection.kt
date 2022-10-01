package com.example.pokedek.model.injection

import com.example.pokedek.model.remote.apiconfig.ApiConfig
import com.example.pokedek.repository.RemoteRepository

object Injection {
    fun provideRepository(): RemoteRepository {
        return RemoteRepository(
            ApiConfig.getApiService()
        )
    }
}