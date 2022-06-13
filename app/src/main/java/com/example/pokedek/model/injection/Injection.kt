package com.example.pokedek.model.injection

import android.content.Context
import com.example.pokedek.model.local.databaseconfig.DatabaseConfig
import com.example.pokedek.model.remote.apiconfig.ApiConfig
import com.example.pokedek.model.repository.RemoteRepository

object Injection {
    fun provideRepository(): RemoteRepository {
        return RemoteRepository(
            ApiConfig.getApiService()
        )
    }
}