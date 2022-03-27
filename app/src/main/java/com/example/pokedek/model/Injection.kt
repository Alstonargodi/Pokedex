package com.example.pokedek.model

import android.content.Context
import com.example.pokedek.model.remote.ApiConfig
import com.example.pokedek.model.remote.ApiRepository
import com.example.pokedek.view.utils.AppExecutors

object Injection {
    fun provideRepository(): ApiRepository{
        return ApiRepository(ApiConfig.getApiService())
    }
}