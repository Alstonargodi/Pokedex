package com.example.pokedek.model.remote.apiconfig

import com.example.pokedek.BuildConfig
import com.example.pokedek.model.remote.apiservice.ApiService
import com.example.pokedek.model.remote.utils.Utils
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    fun getApiService(): ApiService {
        val loggingInterceptor =
            if (BuildConfig.DEBUG)
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            else
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)

        val client =
            OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofit =
            Retrofit.Builder()
                .baseUrl(Utils.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        return retrofit.create(ApiService::class.java)
    }
}