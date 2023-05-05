package com.example.ceritaku_compose.injection

import android.content.Context
import com.example.ceritaku_compose.remote.ApiConfig.ApiConfig
import com.example.ceritaku_compose.repository.RemoteRepository

object Injection {
    fun provideRepository(): RemoteRepository{
        return RemoteRepository(
            ApiConfig.getApiService()
        )
    }
}