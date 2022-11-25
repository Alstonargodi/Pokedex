package com.example.pokedek.model.injection

import android.content.Context
import com.example.pokedek.model.local.mediator.database.MediatorDatabase
import com.example.pokedek.model.remote.apiconfig.ApiConfig
import com.example.pokedek.repository.RemoteRepository

object Injection {
    fun provideRepository(context: Context): RemoteRepository {
        val database = MediatorDatabase.getDatabase(context = context)
        return RemoteRepository(
            ApiConfig.getApiService(),
            database
        )
    }
}